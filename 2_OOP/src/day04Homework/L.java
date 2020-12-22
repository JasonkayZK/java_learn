package day04Homework;

public class L extends Tetromino {

	L() {
		this(0, 0);
	}
	
	L(int row, int col) {
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col + 1);
		cells[2] = new Cell(row, col + 2);
		cells[3] = new Cell(row + 1, col);
	}
	
	public void print() {
		System.out.println("L Module:");
		super.print();
	}
}
