package day02;

import java.util.Scanner;

public class test1 {
	
	public static void main(String[] args) {
		/*
		 * 验证手机号
		 */
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String res = "(\\+86|0086|086|86)?(\\s)*1[\\d]{10}";
		
		/* 
		 * +8613070276321
		 * +86 13070276321
		 * 0086 13070276321
		 */
		System.out.println(input.matches(res));
		scan.close();
		
	}

}
