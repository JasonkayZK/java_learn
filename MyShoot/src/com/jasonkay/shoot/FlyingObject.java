package com.jasonkay.shoot;
import java.awt.image.BufferedImage;

abstract public class FlyingObject {
	protected BufferedImage image; 
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
		
	public abstract void step();
	
	public abstract boolean outOfBounds();
	
	public boolean shootBy(Bullet bullet) {
		int x1 = this.x;
		int x2 = this.x + this.width;
		int y1 = this.y;
		int y2 = this.y + this.height;
		
		int x = bullet.x;
		int y = bullet.y;
		
		return (x > x1 && x < x2) && (y > y1 && y < y2);
	}
	
}
