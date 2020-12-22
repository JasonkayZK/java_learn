package day03;

public class FinallyDemo {

	public static void main(String[] args) {
		System.out.println("Program start!");
		try {
//			String str = null;
			String str = "";
			System.out.println(str.length());
		} catch(Exception e) {
			System.out.println("Unknown error exception!");
		} finally {
			System.out.println("Finally block");
		}
		System.out.println("Program end!");
	}

}
