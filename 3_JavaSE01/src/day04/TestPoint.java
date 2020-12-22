package day04;

public class TestPoint {

	public static void main(String[] args) {
		// 1. Fanxing
		Point<Integer> p1 = new Point<Integer>(1, 2);
		p1.setX(3);
		int x1 = p1.getX();
		System.out.println(x1);
		
		Point<Double> p2 = new Point<> (1.1, 2.2);
		p2.setX(3.3);
		double x2 = p2.getX();
		System.out.println(x2);
		
		Point<String> p3 = new Point<String>("abc", "def");
		p3.setX("aaa");
		System.out.println(p3);
		
		// 2. ClassCastException
		Point<Integer> a1 = new Point<Integer> (1, 2);
		Point a2 = a1;
		a2.setX("abc");
		String str2 = (String)a2.getX();
		System.out.println("x2: " + str2);
		
		x1 = a1.getX();
		System.out.println("x1 : " + x1);
		
		
	}

}
