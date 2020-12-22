package com.jasonkay.shoottest;

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

import com.jasonkay.shoot.FlyingObject;

public class ShootGame extends JPanel {
	
	// Game_score
	private int score;
	
	// Panel Size
	public static final int HEIGHT = 654;
	public static final int WIDTH = 400;
	
	// Image variable
	public static BufferedImage airplane;
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage gameover;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	public static BufferedImage pause;
	public static BufferedImage start;
	public static BufferedImage bigplane;
	
	
	// Game state
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;
	
	// Load static image
	static {
		try {
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bigplane = ImageIO.read(ShootGame.class.getResource("bigplane.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Initiate Game Object
	private Hero hero = new Hero();
	private FlyingObj[] flyings = new FlyingObj[0];
	private Bullet[] bullets = new Bullet[0];
	
	// Create Game Object
	public FlyingObj nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if (type <= 2) {
			return new Bee();
		} else {
			return new Airplane();
		}
	}
	
	// Action
	private void action() { 
		MouseAdapter l = new MouseAdapter() { 
			@Override
			public void mouseMoved(MouseEvent e) {
				if (state == RUNNING) {
					hero.moveTo(e.getX(), e.getY());
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) { 
				switch(state) {
				case ShootGame.START:
					state = RUNNING;
					break;
				case ShootGame.PAUSE:
					state = RUNNING;
					break;
				case ShootGame.GAME_OVER:
					score = 0;
					hero = new Hero();
					flyings = new FlyingObj[0];
					bullets = new Bullet[0];
					state = START;
					break;
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if (state == RUNNING) {
					state = PAUSE;
				}
			}
		};
		
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		
		Timer timer = new Timer();
		int interval = 10; // 10ms per frame
		timer.schedule(new TimerTask() {
			public void run() { // Run schedule! 
				if (state == RUNNING) {
					EnterAction();
					stepAction();
					shootAction();
					outOfBoundsAction();
					bangAction();
					checkGameOverAction();
				}
				repaint();
			}
		}, interval, interval);
		
	}

	protected void checkGameOverAction() { 
		if (isGameOver()) {
			state = ShootGame.GAME_OVER;
		}
	}
	
	private boolean isGameOver() {
		for (int i = 0; i < flyings.length; ++i) {
			if (hero.hit(flyings[i])) { // Hero hit by Enemy
				hero.subtractLife();				
				hero.clearDoubleFire();
				FlyingObj t = flyings[i];
				flyings[i] = flyings[flyings.length - 1];
				flyings[flyings.length - 1] = t;
				flyings = Arrays.copyOf(flyings, flyings.length - 1);
			}
		}
		return hero.getLife() <= 0;
	}

	private boolean bang(Bullet b) { // each bullet bang with Enemy
		int index = -1;
		for (int i = 0; i < flyings.length; ++i) {
			if (flyings[i].shootBy(b)) {
				index = i;
				break;
			}
		}
		if (index != -1) { // Shot by bullet
			if (flyings[index] instanceof Enemy) {
				Enemy e = (Enemy)flyings[index];
				score += e.getScore();
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
			}
			
			FlyingObj t = flyings[index];
			flyings[index] = flyings[flyings.length - 1];
			flyings[flyings.length - 1] = t;
			flyings = Arrays.copyOf(flyings, flyings.length - 1);
			return true;
		}
		return false;
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

	protected void outOfBoundsAction() { // Delete out of bound Object
		int index = 0;
		FlyingObj[] flyingLives = new FlyingObj[flyings.length];
		for (int i = 0; i < flyings.length; ++i) { // Delete the Flyings
			if (!flyings[i].outOfBounds()) {
				flyingLives[index++] = flyings[i];
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		
		index = 0;
		Bullet[] bulletLives = new Bullet[bullets.length];
		for (int i = 0; i < bullets.length; ++i) {
			if (!bullets[i].outOfBounds()) {
				bulletLives[index++] = bullets[i];
			}
		}
		bullets = Arrays.copyOf(bulletLives, index);
	}

	private int shootIndex = 0; // Shoot Frequency Controller
	protected void shootAction() { // Shoot bullet 
		shootIndex++;
		if (shootIndex % 30 == 0) { // shoot every 30 * 10ms
			shootIndex = 0;
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bs.length + bullets.length); // bulletsÀ©ÈÝ
			System.arraycopy(bs, 0, bullets, bullets.length - bs.length, bs.length); // ×·¼ÓÊý×é
		}
	}

	protected void stepAction() {
		hero.step();
		for (int i = 0; i < flyings.length; ++i) {
			flyings[i].step();
		}
		for (int i = 0; i < bullets.length; ++i) {
			bullets[i].step();
		}
	}

	private int flyEnteredIndex = 0;
	protected void EnterAction() { // Create new Enemy
		flyEnteredIndex++;
		if (flyEnteredIndex % 40 == 0) { // Create new Enemy every 10 * 40ms
			flyEnteredIndex = 0;
			FlyingObj one = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length + 1);
			flyings[flyings.length - 1] = one;
		}
	}

	// Show Image
	@Override
	public void paint(Graphics g) {  
		g.drawImage(background, 0, 0, null);
		paintBullets(g);
		paintFlyingObjects(g);
		paintHero(g);
		paintScoreAndLife(g);
		paintAxis(g);
		paintState(g);
	}
	
	private void paintState(Graphics g) { 
		switch(state) {
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

	private void paintScoreAndLife(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g.drawString("Score: " + this.score, 10, 25);
		g.drawString("Life: " + hero.getLife(), 10, 50);
		g.drawString("Double: " + hero.getDoubleFire(), 10, 75);
	}
	
	private void paintAxis(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.drawString("X-Axis: " + hero.getX(), 10, ShootGame.HEIGHT - 75);
		g.drawString("Y-Axis: " + hero.getY(), 10, ShootGame.HEIGHT - 50);
	}

	private void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}

	private void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; ++i) {
			g.drawImage(flyings[i].getImage(), flyings[i].getX(), flyings[i].getY(), null);
		}
	}

	private void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; ++i) {
			g.drawImage(bullets[i].image, bullets[i].x, bullets[i].y, null);
		}
	}

	// Main Entrance
	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.action();
	}

}
