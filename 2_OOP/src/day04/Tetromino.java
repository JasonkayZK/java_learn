package day04;

public class Tetromino {
	Cell[] cells;
	
	Tetromino() {
		cells = new Cell[4];
	}
	
	public void drop() {
		drop(1);
	}
	
	public void drop(int n) {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].row += n;
		}
	}
	
	public void moveLeft() {
		moveLeft(1);
	}
	
 	public void moveLeft(int n) {
		for (int i = 0; i < cells.length; ++i) {
			cells[i].col -= n;
		}
	}
 	
 	public void moveRight() {
 		moveRight(1);
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













