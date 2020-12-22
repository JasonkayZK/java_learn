package com.jasonkay.shoot2_0;

import java.util.Random;

public class BigBee extends FlyingObject implements Award, Enemy {
	private int life;
	private int awardType;
	private int xSpeed;
	private int ySpeed;
	
	public BigBee() {
		this.image = ShootGame.bigbee;
		this.width = image.getWidth();
		this.height = image.getHeight();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.life = 5;
		this.xSpeed = 10;
		this.ySpeed = 1;
		this.awardType = rand.nextInt(2);
	}
	
	public int getXSpeed() {
		return this.xSpeed;
	}
	
	public int getYSpeed() {
		return this.ySpeed;
	}
	
	public void setXSpeed(int speed) {
		this.xSpeed = speed;
	}
	
	public void setYSpeed(int speed) {
		this.ySpeed = speed;
	}
	
	public void decreaseLife() {
		this.life -= 1;
	}
	
	public int getLife() {
		return this.life;
	}
	
	@Override
	public int getScore() {
		
		return 60;
	}

	@Override
	public int getType() {
		
		return this.awardType;
	}

	@Override
	public void step() {
		this.x += this.xSpeed;
		this.y += this.ySpeed;
		if (x >= ShootGame.WIDTH - this.width) {
			this.xSpeed = -this.xSpeed;
		}
		if(x < 0) {
			this.xSpeed = -this.xSpeed;
		}
	}

	@Override
	public boolean outOfBounds() {
		
		return this.y >= ShootGame.HEIGHT;
	}

}
