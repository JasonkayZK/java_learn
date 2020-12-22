package day02;

public class CellTest {

	public static void main(String[] args) {
		Cell c = new Cell();
		c.row = 0;
		c.col = 5;
		System.out.println(c.getCellInfo());
		
		c.drop();
		c.drop(3);
		System.out.println(c.getCellInfo());
		
		c.moveLeft();
		c.moveLeft(3);
		System.out.println(c.getCellInfo());
		
		c.moveRight();
		c.moveRight(3);
		System.out.println(c.getCellInfo());
	}
}
