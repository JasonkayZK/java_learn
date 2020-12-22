package com.jasonkay.shoot;
import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	private int doubleFire;
	private int life;
	private BufferedImage[] images;
	private int index; // Change the image!
	
	public Hero() {
		this.image = ShootGame.hero0;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.x = 150;
		this.y = 400;
		
		this.life = 3;
		this.doubleFire = 10;
		images = new BufferedImage[] {
			ShootGame.hero0, ShootGame.hero1
		};
		this.index = 0;
	}

	@Override
	public void step() { // ÇÐ»»Í¼Æ¬
		index++;
		int a = index / 10;
		int b = a % 2;
		image = images[b];
	}
	
	public Bullet[] shoot() {
		int xStep = this.width / 4; // ·É»ú·Ö¿é
		int yStep = 20; // Bullet Óë Hero ¾àÀë
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
	
	public int getLife() {
		return this.life;
	}

	public int getDoubleFire() {
		return this.doubleFire;
	}
	
	public void moveTo(int x, int y) {
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}

	@Override
	public boolean outOfBounds() {
		return false;
	}
	
	public void addLife() {
		this.life++;
	}
	
	public void addDoubleFire() {
		this.doubleFire += 40;
	}
	
	public boolean hit(FlyingObject obj) {
		int x1 = obj.x - this.width / 2;
		int x2 = obj.x + obj.width + this.width / 2;
		int y1 = obj.y - this.height / 2;
		int y2 = obj.y + obj.height + this.height / 2;
		
		int x = this.x + this.width / 2;
		int y = this.y + this.height / 2;
		
		return (x > x1 && x < x2) && (y > y1 && y < y2);
	}
	
	public void subtractLife() {
		this.life--;
	}
	
	public void clearDoubleFire() {
		this.doubleFire = 0;
	}
	
}
