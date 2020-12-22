package day05;

public class Point implements Comparable<Point> {
	private int x;
	private int y;
	
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
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	private int distance() {
		return x * x + y * y;
	}
	
	@Override
	public int compareTo(Point o) {
		return this.distance() - o.distance();
	}
	
}
