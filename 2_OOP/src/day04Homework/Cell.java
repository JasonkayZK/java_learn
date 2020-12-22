package day04Homework;

public class Cell {
	int row;
	int col;
	
	Cell() {
		row = 0;
		col = 0;
	}
	
	Cell(int n) {
		this(n, n);
	}
	
	Cell(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public String getCellInfo() {
		return (row + ", " + col);
	}
	
}
