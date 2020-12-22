package day01;

public class CellTest {

	public static void main(String[] args) {

		Cell c = new Cell();
		c.row = 0;
		c.col = 5;
		printWall(c);

		c.drop();
		c.moveLeft(2);
		printWall(c);
	}

	public static void printWall(Cell c) {
		for (int i = 0; i < 20; ++i) {
			for (int j = 0; j < 10; ++j) {
				if (i == c.row && j == c.col) {
					System.out.print("* ");
				} else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
