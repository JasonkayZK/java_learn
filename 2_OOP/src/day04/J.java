package day04;

public class J extends Tetromino {
	
	J() {
		this(0, 0);
	}
	
	J(int row, int col) {
		this.cells[0] = new Cell(row, col);
		this.cells[1] = new Cell(row, col + 1);
		this.cells[2] = new Cell(row, col + 2);
		this.cells[3] = new Cell(row + 1, col + 2);
	}
	
	public void print() {
		System.out.println("I am a J:");
		super.print();
	}
}
