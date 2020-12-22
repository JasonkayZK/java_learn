package com.jasonkay.shoot;
 
import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	private int speed;
	
	Airplane() {
		this.image = ShootGame.airplane;
		this.width = image.getWidth();
		this.height = image.getHeight();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		
		this.speed = 2;
	}
	
	@Override
	public int getScore() {
		
		return 5;
	}


	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void step() {
		this.y += this.speed;
	}

	@Override
	public boolean outOfBounds() {
		return this.y >= ShootGame.HEIGHT;
	}
}
