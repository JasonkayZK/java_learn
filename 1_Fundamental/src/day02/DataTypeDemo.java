package day02;

public class DataTypeDemo {

	public static void main(String[] args) {
/*
		int a = 250;
		//int b = 10000000000;
		System.out.println(5/2); // 2
		System.out.println(2/5); // 0
		int c = 2147483647;
		System.out.println(c + 1); // -2147483648
		 
		//long d = 10000000000;
		long e = 10000000000L;
		long f = 1000000000 * 2 * 10L;
		long g = 1000000000 * 3 * 10L;
		long h = 1000000000L * 3 * 10;
		System.out.println(e); // 1000000000
		System.out.println(f); // 2000000000
		System.out.println(g); // Overflow
		System.out.println(h); // 3000000000
		long i = System.currentTimeMillis(); 
		System.out.println(i); // Current Time
		
		double j = 3.14;
		double k = 6.0, l = 4.9;
		System.out.println(k - l); // 1.0999999999996
		
		boolean b1 = true;
		boolean b2 = false;
		//boolean b3 = 250;
		
		char c1 = 'Å®';
		char c2 = 'f';
		char c3 = '6';
		char c4 = ' ';
		//char c5 = 'ÖÐ¹ú';
		//char c6 = '';
		char c7 = 65;
		System.out.println(c7); // A
		System.out.println(2 + 2); // 4
		System.out.println(2 + '2'); // 52
		System.out.println('2' + '2'); // 100
		System.out.println("2" + "2"); // 22
*/
		int a = 250;
		long b = a;
//		int c = b;
		long d = 250;
		double e = 250;
		System.out.println(e); // 250.0
		
		long f = 10000000000L;
		int g = (int)f;
		System.out.println(g); // Overflow
		
		double h = 25.98;
		int i = (int)h;
		System.out.println(i); // 25
		
		byte b1 = 5;
		byte b2 = 6;
		byte b3 = (byte)(b1 + 3);
		System.out.println(b3); // 11
		
		 
		
	}

}
