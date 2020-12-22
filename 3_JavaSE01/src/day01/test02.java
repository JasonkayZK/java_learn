package day01;

public class test02 {

	public static void main(String[] args) {
		String info = "abcdedcba";
		for (int i = 0; i < info.length() / 2; ++i) {
			if (info.charAt(i) 
					!= 
				info.charAt(info.length() - 1 - i)) {
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
	}

}
