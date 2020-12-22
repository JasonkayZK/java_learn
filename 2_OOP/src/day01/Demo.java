package day01;

public class Demo {

	public static void main(String[] args) {
		Cell c1 = new Cell();
		Cell c2 = c1;
		c1.row = 5;
		c2.row = 2;
		System.out.println(c1.row);
		
		//Cell c3 = new Cell();
		//c3 = null;
		//c3.col = 2;

	}

}
