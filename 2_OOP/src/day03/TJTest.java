package day03;

public class TJTest {

	public static void main(String[] args) {
		T t = new T(3, 3);
		printWall(t);
		J j = new J(3, 2);
		printWall(j);
	}

	// 效率略低， 但是扩展性强！
	public static void printWall(Tetromino t) {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 10; ++j) {
				boolean flag = false;
				for (int k = 0; k < t.cells.length; k++) {
					if (i == t.cells[k].row && j == t.cells[k].col) {
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.print("* ");
				} else {
					System.out.print("- ");
				}				
			}
			System.out.println();
		}
	}
	
	
	/* 扩展性差， 效率高
	public static void printWall(T t) {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (i == t.cells[0].row && j == t.cells[0].col
					|| 
					i == t.cells[1].row && j == t.cells[1].col
					||
					i == t.cells[2].row && j == t.cells[2].col
					||
					i == t.cells[3].row && j == t.cells[3].col) {
					System.out.print("* ");
				} else {
					System.out.print("- ");
				}				
			}
			System.out.println();
		}
	}
	*/
}
