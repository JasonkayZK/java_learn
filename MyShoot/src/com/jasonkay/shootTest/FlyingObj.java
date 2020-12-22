package com.jasonkay.shoottest;

import java.awt.image.BufferedImage;

public abstract class FlyingObj {
	protected int height;
	protected BufferedImage image;
	protected int width;
	protected int x;
	protected int y;
	
	public int getHeight() {
		return this.height;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public void setHeight(int h) { 
		this.height = h;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void setWidth(int w) {
		this.width = w;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public abstract void step();
	
	public abstract boolean outOfBounds();
	
	public boolean shootBy(Bullet bullet) {
		int x1 = this.x;
		int x2 = this.x + this.width;
		int y1 = this.y;
		int y2 = this.y + this.height;
		
		int x = bullet.getX();
		int y = bullet.getY();
		
		return (x > x1 && x < x2) && (y > y1 && y < y2);
	}
	
}




















