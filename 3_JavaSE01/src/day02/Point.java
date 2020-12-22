package day02;
/**
 * 使用该类来测试Object相关方法的重写
 * Present a point in 2-D 
 * @author ZK
 *
 */
public class Point {
	private int x;
	private int y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "X: " + this.x + ", Y: " + this.y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		} else if (other == this) {
			return true;
		} else if (other instanceof Point) {
			Point p = (Point)other;
			return this.x == p.x && this.y == p.y;
		} else {
			return false;
		}
	}
	
}
