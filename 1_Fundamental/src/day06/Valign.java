package day06;
import java.util.Scanner;
public class Valign {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the string: ");
		String input = scan.next().trim();
		char[] chs = input.toCharArray();
		int valign = 0;
		do {
			System.out.print("Please input the valign number: ");
			valign = scan.nextInt();
		} while(valign <= 0);
		for (int i = 0; i < chs.length; ++i) {
			System.out.print(chs[i]);
			if ((i + 1) % valign == 0) System.out.println();
		}
		scan.close();
	}

}
