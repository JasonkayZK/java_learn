package day02;

public class IntegerDemo {

	public static void main(String[] args) {
		// 1. Create
		Integer i1 = new Integer(123);
		Integer i2 = new Integer(123);
		System.out.println(i1 == i2);
		
		i1 = Integer.valueOf(123);
		i2 = Integer.valueOf(123);
		System.out.println(i1 == i2);
		
		i1 = Integer.valueOf(128);
		i2 = Integer.valueOf(128);
		System.out.println(i1 == i2);
		
		// 2. Reverse
		Integer i3 = Integer.valueOf(128);
		byte b = i3.byteValue();
		System.out.println(b); // -128
		
		Double d1 = Double.valueOf(123.33);
		int i = d1.intValue();
		System.out.println(i); // Int part
		
		// 3. MAX & MIN
		double max = Double.MAX_VALUE;
		double min = Double.MIN_VALUE;
		System.out.println("max: " + max);
		System.out.println("min: " + min);
		
		// 4. parse
		double d = Double.parseDouble("100e3");
		System.out.println(d);
		
		// 5. Auto-Pack & unpack
		int i4 = new Integer(1);
		Integer ii = 123;
		
		
		
	}

}
