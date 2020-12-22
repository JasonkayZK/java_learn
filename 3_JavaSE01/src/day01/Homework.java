package day01;

public class Homework {

	public static void main(String[] args) {
		String str = "Helloworld";
		
		System.out.println(str.length());
		
		System.out.println(str.indexOf('o'));
		
		System.out.println(str.indexOf('o', 5));
		
		System.out.println(str.substring(0, 5));
		
		System.out.println(str.substring(5));
		
		str = "   Hello    ";
		
		System.out.println(str.trim());
		
		str = "HelloWorld";
		
		System.out.println(str.charAt(5));
		
		System.out.println(str.startsWith("h") && str.endsWith("ld"));
		
		System.out.println(str.toUpperCase());
		
		System.out.println(str.toLowerCase());
		
	}

}
