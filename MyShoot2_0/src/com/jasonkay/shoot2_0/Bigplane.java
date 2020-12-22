package com.jasonkay.shoot2_0;

import java.util.Random;

public class Bigplane extends FlyingObject implements Enemy {
	private int speed;
	private int life;
	
	public Bigplane() {
		this.image = ShootGame.bigplane;
		this.height = image.getHeight();
		this.width = image.getWidth();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.speed = 1;
		this.life = 3;
	}
	
	@Override
	public int getScore() {
		
		return 40;
	}

	@Override
	public void step() {
		this.y += this.speed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;
	}
	
	public void decreaseLife() {
		this.life -= 1;
	}
	
	public int getLife() {
		return this.life;
	}
	
}
