package day02;

public class Cell {
	int row;
	int col;
	
	Cell() {
		this(0, 0);
	}
	
	Cell(int n) {
		this(n, n);
	}
	
	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	Cell(Cell other) {
		this.row = other.row;
		this.col = other.col;		
	}
	
	public void drop() {
		row++;
	}
	 
	public void drop(int n) {
		row -= n;
	}
	
	public void moveLeft(int n) {
		col -= n;
	}
	
	public void moveLeft() {
		col--;
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
