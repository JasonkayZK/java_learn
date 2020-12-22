package day03Homework;

public class TJTest {

	public static void main(String[] args) {
		Tetromino t = new T(3, 2);
		printWall(t);
		System.out.println();
		
		J j = new J(1, 2);
		printWall(j);
		System.out.println();
		
		L l = new L(4, 4);
		printWall(l);
		System.out.println();
		
		O o = new O(4, 4);
		printWall(o);
		System.out.println();
		
		S s = new S(4, 4);
		printWall(s);
		System.out.println();
		
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
