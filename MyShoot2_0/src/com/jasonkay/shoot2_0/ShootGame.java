package com.jasonkay.shoot2_0;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ShootGame extends JPanel {
	private int score;
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage bigplane;
	public static BufferedImage bigbee;
	public static BufferedImage enemybullet;
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START; // Current State

	private Hero hero = new Hero(); 
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	
	static {
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			bigplane = ImageIO.read(ShootGame.class.getResource("bigplane.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			bigbee = ImageIO.read(ShootGame.class.getResource("bigbee.png"));
			enemybullet = ImageIO.read(ShootGame.class.getResource("enemybullet.png"));
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}

	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(100);
		if (type <= 10) {
			return new BigBee();
		} else if (type <= 30){
			return new Bigplane();
		} else if (type <= 60) {
			return new Bee();
		} else {
			return new Airplane();
		}
	}
	
	public int flyEnteredIndex = 0;
	public void enterAction() { // 敌人入场
		flyEnteredIndex++;
		if (flyEnteredIndex % 40 == 0) { // interval * 40ms 走一次
			flyEnteredIndex = 0;
			FlyingObject one = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);
			flyings[flyings.length - 1] = one;
		}
	}
	
	public void stepAction() { // FlyingObject Move, 10ms 
		hero.step(); // Hero move
		for (int i = 0; i < flyings.length; ++i) {
			flyings[i].step(); // Enemy move
		}
		for (int i = 0; i < bullets.length; ++i) {
			bullets[i].step(); // Bullets move
		}
	}
	
	int shootIndex = 0;
	public void shootAction() { // Bullet Move
		shootIndex++;
		if (shootIndex % 4 == 0) {
			shootIndex = 0;
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bs.length + bullets.length); // bullets扩容
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length); // 追加数组
		}
	}
		
	public void outOfBoundsAction() { 
		// Delete Out of bound FlyingObjects
		int index = 0;
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		for (int i = 0; i < flyings.length; ++i) {
			if (!flyings[i].outOfBounds()) {
				flyingLives[index++] = flyings[i];
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		// Delete Out of bound Bullets
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; ++i) {
			if (!bullets[i].outOfBounds()) {
				bulletLives[index++] = bullets[i];
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}
	
	protected void bangAction() { // Bang for every Bullet
		for (int i = 0; i < bullets.length; ++i) {
			if (bang(bullets[i])) { // If banged delete the bullet
				Bullet t = bullets[i];
				bullets[i] = bullets[bullets.length - 1];
				bullets[bullets.length - 1] = t;
				bullets = Arrays.copyOf(bullets, bullets.length - 1);
			}
		}
	}
	
	public boolean bang(Bullet b) { 
		int index = -1;
		boolean deathFlag = false;
		for (int i = 0; i < flyings.length; ++i) {
			if (flyings[i].shootBy(b)) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			if (flyings[index] instanceof Enemy) {
				Enemy e = (Enemy)flyings[index];
				score += e.getScore();
				deathFlag = true;
			}
			if (flyings[index] instanceof Award) {
				Award a = (Award)flyings[index];
				switch(a.getType()) {
					case Award.DOUBLE_FIRE:
						hero.addDoubleFire();
						break;
					case Award.LIFE:
						hero.addLife();
						break;
				}
				deathFlag = true;
			}
			if (flyings[index] instanceof Bigplane) { // Decrease the life of bigplane
				Bigplane big = (Bigplane)flyings[index];
				if (big.getLife() > 1) {
					big.decreaseLife();
					deathFlag = false;
				} else {
					deathFlag = true;
				}
			}
			if (flyings[index] instanceof BigBee) { // Decrease the life of BigBee
				BigBee bb = (BigBee)flyings[index];
				if (bb.getLife() > 1) {
					bb.decreaseLife();
					deathFlag = false;
				} else {
					switch(bb.getType()) {
					case Award.DOUBLE_FIRE:
						hero.addDoubleFire();
						break;
					case Award.LIFE:
						hero.addLife();
						break;
					}
					deathFlag = true;
				}
			}
			if (deathFlag) {
				FlyingObject t = flyings[index];
				flyings[index] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);				
			}
			return true;
		}
		return false;
	}
	
	public void checkGameOverAction() { 
		if (isGameOver()) {
			state = GAME_OVER;
		}
	}
	
	public boolean isGameOver() { 
		for (int i = 0; i < flyings.length; ++i) {
			if (hero.hit(flyings[i])) {
				hero.subtractLife();
				hero.clearDoubleFire();
				FlyingObject t = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;
	}
	
	public void action() {
		MouseAdapter l = new MouseAdapter() {  
			@Override
			public void mouseMoved(MouseEvent e) { // 鼠标移动就自动执行！
				if (state == RUNNING) {
					int x = e.getX();
					int y = e.getY();
					hero.moveTo(x, y);					
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { // 鼠标点击执行
				switch(state) {
				case START:
					state = RUNNING;
					break;
				case GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
					break;
				case PAUSE:
					state = RUNNING;
					break;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) {
					state = PAUSE;
				}
			}
/*			
			@Override
			public void mouseEntered(MouseEvent e) {
				if (state == PAUSE) {
					state = RUNNING;
				}
			}
*/			
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		
		Timer timer = new Timer();
		int interval = 10; // 时间间隔 ms 
		timer.schedule(new TimerTask() { 
			public void run() { // 定时做的事 
				if (state == RUNNING) {
					enterAction(); // 入场方法
					stepAction(); // FlyingObject移动方法
					shootAction();
					outOfBoundsAction();
					bangAction();
					checkGameOverAction();	
				}
				repaint();
			}
		}, interval, interval);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyingObjects(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
		paintAxis(g);
	}
	
	public void paintScoreAndLife(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.drawString("Score: " + score, 10, 25);
		g.drawString("Life: " + hero.getLife(), 10, 50);
		g.drawString("DoubleFire: " + hero.getDoubleFire(), 10, 75);
	}
	
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
		
	}
	
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; ++i) {
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
			
	}
	
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; ++i) {
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
		
	}
		
	public void paintState(Graphics g) {

		switch(this.state) {
		case START:
			g.drawImage(start, 30, 0, null);
			break;
		case PAUSE:
			g.drawImage(pause, 30, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 30, 0, null);
			break;
		}
	}
	
	private void paintAxis(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.drawString("X-Axis: " + hero.getX(), 10, ShootGame.HEIGHT - 75);
		g.drawString("Y-Axis: " + hero.getY(), 10, ShootGame.HEIGHT - 50);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true); 
		
		game.action(); // 启动程序执行
	}
	
	
}



















