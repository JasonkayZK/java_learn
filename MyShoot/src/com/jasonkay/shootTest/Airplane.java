package com.jasonkay.shoottest;

import java.util.Random;

public class Airplane extends FlyingObj implements Enemy {
	private int speed;
	
	Airplane() {
		this.image = ShootGame.airplane;
		this.height = image.getHeight();
		this.width = image.getWidth();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.speed = 2;
	}
	
	@Override
	public int getScore() {
		
		return 5;
	}

	@Override
	public void step() {
		this.y += this.speed;
	}
	
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;
	}
	

}
