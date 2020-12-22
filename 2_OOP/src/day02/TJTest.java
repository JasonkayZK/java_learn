package day02;

public class TJTest {

	public static void main(String[] args) {
		T t1 = new T();
		t1.print();
		
		t1.drop();
		t1.moveLeft();
		t1.print();
		t1.moveRight(2);
		t1.print();
		
		T t2 = new T(2,2);
		t2.print();
		
		J j1 = new J();
//		J j2 = new J(2, 2);
				
		j1.print();
		
		j1.drop();
		j1.moveLeft();
		j1.print();
		

	}

}
