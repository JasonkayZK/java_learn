package com.jasonkay.mangame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManGame extends JFrame {
	/**
	 * This method initializes JBotton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton jButton1;
	private JLabel jLabel;
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(478, 361, 164, 51));
			jButton1.setText("Restart");
			jButton1.setVisible(false);
			jButton1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					jButton1.setVisible(false);
					jLabel.setVisible(false);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return jButton1;
	}
	
	public static void main(String[] args) {
		ManGame game = new ManGame();
		game.start();
		game.reset();
		game.gogo();
	}

	/**
	 * Use default constructor to initiate the game
	 */
	public ManGame() {
		super();
		initialize();
	}
	
	public void reset() { 
		kup = false;
		kdown = false;
		kleft = false;
		kright = false;
		int initBullet = 0;
		while (initBullet < bulletNum) {
			((JButton) buttonal.get(initBullet)).setBounds(new Rectangle(-50,
					-50, 10, 10));
			initBullet++;
		}
		bulletCircle = true;
		jButton.setIcon(new ImageIcon(fileLoc));
		jButton.setLocation(320, 320);
		p = jButton.getLocation();
		x=p.getX();
		y=p.getY();
		firsttime=new Date().getTime();		
	}
	
	public void start() { 
		// Initialize the Bullet
		int initBullet = 0;
		while (initBullet < bulletNum) {
			JButton jb = new JButton();
			jb.setBounds(new Rectangle(-50, -50, 10, 10));
			jb.setEnabled(false);
			Threads ths = new Threads(jb);
			Thread th = new Thread(ths);
			buttonal.add(jb);
			threadal.add(th);
			initBullet++;
		}
		ManGame.Move move = new Move();
		Thread tm = new Thread(move);
		tm.start();
	}
	
	public void gogo() { 
		int initBullet = 0;
		while (initBullet < bulletNum) {
			((Thread) threadal.get(initBullet)).start();
			initBullet++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
	
	// Game Score, hold on full second!
	private long firsttime;
	private long lasttime;
	private static final long serialVersionUID = 1L;
	
	private boolean kup;
	private boolean kdown;
	private boolean kleft;
	private boolean kright;
	
	// The move Speed of the player
	private int step = 6;
	
	private Point p;
	private double x = 0.0;
	private double y = 0.0;
	
	// The total number of the bullets
	private int bulletNum = 100;
	
	// Define the Circulation of the bullets
	private boolean bulletCircle = true;
	
	private ArrayList<JButton> buttonal = new ArrayList<JButton>();
	private ArrayList<Thread> threadal = new ArrayList<Thread>();
	
	URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
	URL fileLoc = urlLoader.findResource(".\\image\\hero.gif");
	URL fileLoc1 = urlLoader.findResource(".\\image\\enemy.bmp");
	
	/**
	 * Initialize the Game
	 * 
	 * @return void
	 * 
	 */
	private void initialize() {
		// Set size of the Panel
		this.setSize(700, 700);
		// Set Listener for the Panel
		this.addWindowListener(new WindowAdapter() {
			// Exit while closing the window
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		// Do not let the player to resize the Panel
		this.setResizable(false);
		// Set panel
		this.setContentPane(getJPanel());
		this.setTitle("Jasonkay's Game! Hold on for 100 sec");
		this.setVisible(true);
	}

	private JPanel jPanel;
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(42, -33, 595, 308));
			jLabel.setFont(new Font("Dialog", Font.BOLD, 24));
			jLabel.setForeground(new Color(250, 2, 2));
			jLabel.setEnabled(true);
			jLabel.setVisible(false);
			
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJButton(), null);
			jPanel.setForeground(new Color(1, 1, 1));
			jPanel.setBackground(new Color(1, 1, 1));
			jPanel.setVisible(true);
			jPanel.add(jLabel, null);
			jPanel.add(getJButton1(), null);
		}
		return jPanel;
	}

	class Move implements Runnable {
		public void run() {
			while (true) {
				// Game running
				while (bulletCircle) {
					// Move hero
					p = jButton.getLocation();
					x = p.getX();
					y = p.getY();
					if (kup) { // Main push is up
						if (kleft) { // pushed up & left
							if (x > 0 && y > 0) { // Valid Position
								jButton.setLocation((int) x - step, (int)y - step);
							}
						} else if (kright) { // pushed up & right
							if (x + 40 < 700 && y > 0) { // Valid Position
								jButton.setLocation((int) x + step, (int) y - step);
							}
						} else {
							if (y > 0) { // pushed up Only
								jButton.setLocation((int) x, (int) y - step);
							}
						}
					}
					if (kdown) { // Main push is down
						if (kleft) { // pushed down & left
							if (y + 60 < 700 && x > 0) {
								jButton.setLocation((int) x - step, (int) y + step);								
							}
						} else if (kright) {
							if (x + 40 < 700 && y + 60 < 700) {
								jButton.setLocation((int) x + step, (int) y + step);
							}
						} else {
							if (y + 60 < 700) {
								jButton.setLocation((int) x, (int) y + step);
							}
						}
					}
					if (kleft) {
						if (kup) {
							if (x > 0 && y > 0) {
								jButton.setLocation((int) x - step, (int) y - step);
							}
						} else if (kdown) {
							if (y + 60 < 700 && x > 0) {
								jButton.setLocation((int) x - step , (int) y + step);
							}
						} else {
							if (x > 0) {
								jButton.setLocation((int) x - step, (int) y);
							}
						}
					}
					if (kright) {
						if (kup) {
							if (x + 40 < 700 && y > 0) {
								jButton.setLocation((int) x + step, (int) y - step);
							}
						} else if (kdown) {
							if (x + 40 < 700 && y + 60 < 700) {
								jButton.setLocation((int) x + step, (int) y + step);
							}
						} else {
							if (x + 40 < 700) {
								jButton.setLocation((int) x + step, (int) y);
							}
						}
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// Create main Player Block
	private JButton jButton;
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(320, 320, 30, 30);
			jButton.setBackground(new Color(1, 1, 1));
			p = jButton.getLocation();
			x = p.getX();
			y = p.getY();
			jButton.setIcon(new ImageIcon(fileLoc));
			// when press the key change the key state to true, and let the block to move
			// when release the key, change the key state to false!
			jButton.addKeyListener(new KeyAdapter() {
				@Override
				// Key release action
				public void keyReleased(KeyEvent e) {
					if (e.getKeyCode() == 10) { // Enter
						if (!bulletCircle) {
							jButton1.setVisible(false);
							jLabel.setVisible(false);
							reset();
						}
					}
					
					if (e.getKeyCode() == 37) { // Left
						kleft = false;
					}
					if (e.getKeyCode() == 38) { // Up
						kup = false;
					}
					if (e.getKeyCode() == 39) { // Right
						kright = false;
					}
					if (e.getKeyCode() == 40) { // Down
						kdown = false;
					}
				}

				// Key press action
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == 37) {
						kleft = true;
					}
					if (e.getKeyCode() == 38) {
						kup = true;
					}
					if (e.getKeyCode() == 39) {
						kright = true;
					}
					if (e.getKeyCode() == 40) {
						kdown = true;
					}
				}
				
			});
		}
		return jButton;
	}
	
	// Create the enemy block
	class Threads implements Runnable { 
		private JButton jb;
		// First create block is different!
		private boolean first = true;
		
		public Threads(JButton jjb) {
			jb = jjb;
		}

		@Override
		public void run() { 
			while (bulletCircle) {
				go();
			}
		}
		
		public void go() { 
			int zzx = 0;
			int zzy = 0;
			int zx = 0;
			int zy = 0;
			while (true) {
				if (bulletCircle) {
					// Create bullet from 4-size of the border
					int dir = (int)(Math.random() * 4 + 1);
					if (dir == 1) {
						zx = 0;
						zy = (int)(Math.random() * 701);
					}
                    if (dir == 2) {
                        zx = (int) (Math.random() * 701);
                        zy = 0;
                    }
                    if (dir == 3) {
                        zx = 700;
                        zy = (int) (Math.random() * 701);
                    }
                    if (dir == 4) {
                        zx = (int) (Math.random() * 701);
                        zy = 700;
                    }
                    // Initialize the bullets, do not create if bullet is exist
                    if (first) {
                    	jPanel.add(jb, null);
                    	first = false;
                    }
    				jb.setBounds(new Rectangle(zx, zy, 10, 10));
    				// xspeed & yspeed of the enemy, ����ԽԶ�� �ٶ�Խ��
    				zzx = (int)(((x + 15) - zx) / 30);
    				zzy = (int)(((y + 15) - zy) / 30);
    				
    				
				}
				while(bulletCircle) {
					try {
						zx += zzx;
						zy += zzy;
						jb.setLocation(zx, zy);
						if (zx + 5 > x & zx + 5 < x + 30 & zy + 5 > y
								& zy + 5 < y + 30) { // Crashed!
							jButton.setIcon(new ImageIcon(fileLoc1));
							bulletCircle = false;
							first = true;
							jButton1.setVisible(true);
							jLabel.setVisible(true);
							lasttime = new Date().getTime();
							Date gametime = new Date(lasttime - firsttime);
							@SuppressWarnings("deprecation")
							int min = gametime.getMinutes();
							@SuppressWarnings("deprecation")
							int sec = gametime.getSeconds();
							String endtime = "";
							if (min != 0) {
								endtime = min + "min " + sec + " seconds";								
							} else {
								endtime = sec + " seconds";
							}
							jLabel.setText("                GAME OVER!  " + "Your Time: " + endtime);
							break;
						}
						if (zx > 700 | zy > 700 | zx < 0 | zy < 0) {
							break;
						}
						Thread.sleep(60);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(50);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
