package day04Homework;

public class TetrominoTest {

	public static void main(String[] args) {
		I i1 = new I(2, 3);
		J j1 = new J(4, 5);
		L l1 = new L(1 ,3);
		O o1 = new O(5, 7);
		T t1 = new T(3, 4);
		
		i1.print();
		i1.drop(2);
		i1.moveLeft(2);
		i1.print();
		
		j1.print();
		l1.print();
		o1.print();
		t1.print();
		
		printWall(i1);
		printWall(j1);
		
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
