package com.jasonkay.shoottest;

import java.util.Random;

public class Bee extends FlyingObj implements Award {
	private int awardType;
	private int xSpeed;
	private int ySpeed;
	
	Bee() {
		this.image = ShootGame.bee;
		this.height = image.getHeight();
		this.width = image.getWidth();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.ySpeed = 2;
		this.xSpeed = 1;
		this.awardType = rand.nextInt(2);
	}
	
	public int getType() {
		return this.awardType;
	}
	
	public int getXSpeed() {
		return this.xSpeed;
	}
	
	public int getYSpeed() {
		return this.ySpeed;
	}

	@Override
	public void step() {
		this.x += this.xSpeed;
		this.y += this.ySpeed;
		if (x >= ShootGame.WIDTH - this.x) {
			xSpeed = -1;
		}
		if (x <= 0) {
			xSpeed = 1;
		}
		
	}

	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;
	}
	
	public void setXSpeed(int speed) {
		this.xSpeed = speed;
	}
	
	public void setYSpeed(int speed) {
		this.ySpeed = speed;
	}
	
}
