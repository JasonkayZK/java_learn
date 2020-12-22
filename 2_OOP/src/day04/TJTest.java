package day04;

public class TJTest {

	public static void main(String[] args) {
		J j = new J(3,4);
		j.print();
		
		Tetromino t = new T(5,6);
		t.print();
	}
	
	public static void printWall(Tetromino t) {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 10; ++j) {
				
				boolean flag = false;
				for (int k = 0; k < t.cells.length; ++k) {
					if (t.cells[k].row == i && t.cells[k].col == j) {
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
}
