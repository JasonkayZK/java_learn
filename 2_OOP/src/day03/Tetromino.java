package day03;

public class Tetromino {
	Cell[] cells;
	
	Tetromino() {
		cells = new Cell[4];
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
			String str = cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}
















