package com.jasonkay.shoottest;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObj {
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	private int life;
	
	public Hero() {
		this.images = new BufferedImage[] {
			ShootGame.hero0, ShootGame.hero1
		};
		this.index = 0;
		this.image = ShootGame.hero0;
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.x = 150;
		this.y = 400;
		
		this.doubleFire = 40;
		this.life = 3;
	}

	public void addDoubleFire() {
		this.doubleFire += 40;
	}
	
	public void addLife() {
		this.life += 1;
	}
	
	public void clearDoubleFire() {
		this.doubleFire = 0;
	}
	
	public int getDoubleFire() {
		return this.doubleFire;
	}
	
	public int getLife() {
		return this.life;
	}
	
	public boolean hit(FlyingObj obj) {
		int x1 = obj.x - this.width / 2;
		int x2 = obj.x + obj.width + this.width / 2;
		int y1 = obj.y - this.height / 2;
		int y2 = obj.y + obj.height + this.height / 2;
		
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		
		return (x > x1 && x < x2) && (y > y1 && y < y2);
	}
	
	public void moveTo(int x, int y) {
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}
	
	@Override
	public void step() { // Switch Image
		index++;
		int a = index / 10;
		int b = (a & 1);
		if (index >= 10000) index = 0;
		this.image = images[b];
	}

	@Override
	public boolean outOfBounds() {
		return false;
	}
	
	public void subtractLife() {
		this.life -= 1;
	}
	
	public Bullet[] shoot() {
		int xStep = this.width / 4; // Split the hero Image
		int yStep = 20; // Initiate bullet Distance
		if (doubleFire > 0) {
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x + xStep * 1, this.y - yStep);
			bs[1] = new Bullet(this.x + xStep * 3, this.y - yStep);
			this.doubleFire -= 2;
			return bs;
		} else {
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x + xStep * 2, this.y - yStep);
			return bs;
		}
	}

}
