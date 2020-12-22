package day01;

public class StringDemo0 {

	public static void main(String[] args) {
		String s1 = "abc123";
		String s2 = "abc123";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = new String("abc123");
		System.out.println(s2 == s3);
		
		String s4 = "abc" + "123";
		System.out.println(s2 == s4);
		
		String str1 = "abc";
		String str2 = "123";
		String s5 = str1 + str2;
		System.out.println(s2 == s5);
		
		s1 = s1 + "!";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1);
		System.out.println(s2);
		
		
	}
}
