package day03;

public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println("Program start!");
		try {
		String str = "a";
		System.out.println(str.length());
		System.out.println(str.charAt(0));
		System.out.println(Integer.parseInt(str));
		} catch(NullPointerException e) {
			System.out.println("Null Pointer Exception!");
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("String index out of bounds Exception!");
		} catch(Exception e) {
			System.out.println("Unkonwn error occured!");
		}
		
		System.out.println("Program stop!");
	}

}
