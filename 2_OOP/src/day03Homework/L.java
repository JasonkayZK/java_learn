package day03Homework;

public class L extends Tetromino {
	
	L() {
		this(0, 0);
	}
	
	L(int row, int col) {
		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row, col + 1);
		this.cells[2] = new Cell(row, col + 2);
		this.cells[3] = new Cell(row + 1, col);
	}
}
