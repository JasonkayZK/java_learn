package day01;

public class Cell {
	int row;
	int col;
	
	public void drop() {
		row++;
	}
	
	public void moveLeft(int n) {
		col -= n;
	}
	
	public void moveRight() {
		col += 1;
	}
	
	public void moveRight(int n) {
		col += n;
	}
	
	public String getCellInfo() {
		return row + ", " + col;
	}
}
