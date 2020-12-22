package com.jasonkay.shoot;

public class Bullet extends FlyingObject {
	private int speed;
	
	public Bullet(int x, int y) {
		this.image = ShootGame.bullet;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.x = x;
		this.y = y;
		
		this.speed = 2;
	}

	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void step() {
		this.y -= this.speed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y <= -this.height;
	}
	
	
}
