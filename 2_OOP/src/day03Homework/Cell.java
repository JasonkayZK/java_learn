package day03Homework;

public class Cell {
	int row;
	int col;
	
	Cell() {
		row = 0;
		col = 0;
	}
	
	Cell(int n) {
		this(n ,n);
	}
	
	Cell(int r, int c) {
		row = r;
		col = c;
	}
	
	public String getCellInfo() {
		return row + ", " + col;
	}
	
}
