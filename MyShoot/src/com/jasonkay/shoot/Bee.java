package com.jasonkay.shoot;
import java.util.Random;

public class Bee extends FlyingObject implements Award {
	private int xSpeed;
	private int ySpeed;
	private int awardType;

	Bee() {
		this.image = ShootGame.bee;
		this.width = image.getWidth();
		this.height = image.getHeight();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.xSpeed = 1;
		this.ySpeed = 2;
		this.awardType = rand.nextInt(2);
	}
		
	@Override
	public int getType() {
		return this.awardType;
	}

	public int getXSpeed() {
		return this.xSpeed;
	}
	
	public void setXSpeed(int speed) {
		this.xSpeed = speed;
	}
	
	public int getYSpeed() {
		return this.ySpeed;
	}
	
	public void setYSpeed(int speed) {
		this.ySpeed = speed;
	}

	@Override
	public void step() {
		this.x += this.xSpeed;
		this.y += this.ySpeed;
		if (x >= ShootGame.WIDTH - this.width) {
			this.xSpeed = -1;
		}
		if(x < 0) {
			this.xSpeed = 1;
		}
	}

	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;
	}	
	
}
