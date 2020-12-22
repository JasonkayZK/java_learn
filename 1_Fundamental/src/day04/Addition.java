package day04;
import java.util.Scanner;
public class Addition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int score = 0;
		for (int i = 1; i <= 10; ++i) {
			int a = (int)(Math.random() * 100);
			int b = (int)(Math.random() * 100);
			System.out.println("(" + i + ")" + a + " + " + b + "= ?");
			
			int user_input = scan.nextInt();
			if (user_input == -1) break;
			if (user_input == a + b) score += 10;
		}
		System.out.println("Your score is: " + score);
		scan.close();
	}

}
