package day02;

public class O {
	Cell[] cells;
	
	O() {
		this(0, 0);
	}
	
	O(int row, int col) {
		cells = new Cell[4];
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col + 1);
		cells[2] = new Cell(row + 1, col);
		cells[3] = new Cell(row + 1, col + 1);
	}
	
	public void drop() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].row++;
		}
	}
	
	public void moveLeft() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col--;
		}
	}
	
	public void moveRight() {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col++;
		}
	}
	
	public void print() {
		for (int i = 0; i < cells.length; ++i) {
			String str = cells[i].getCellInfo();
			System.out.println(str);
		}
	}
}
