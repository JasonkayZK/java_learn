package day02;

public class T {
	Cell[] cells;
	T() {
		this(0, 0);
	}
	
	T(int row, int col) {
		this.cells = new Cell[4];
		this.cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col + 1);
		cells[2] = new Cell(row, col + 2);
		cells[3] = new Cell(row + 1, col + 1);
	}
	
	public void drop() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].row++;
		}
	}
	
	public void drop(int n) {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].row += n;
		}
	}
	
	public void moveLeft() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col--;
		}
	}
	
	public void moveLeft(int n) {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col -= n;
		}
	}
	
	public void moveRight() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col++;
		}
	}
	
	public void moveRight(int n) {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col += n;
		}
	}
 
	public void print() {
		for (int i = 0; i < cells.length; ++i) {
			String str = this.cells[i].getCellInfo();
			System.out.println(str);
		}
	}
} 









