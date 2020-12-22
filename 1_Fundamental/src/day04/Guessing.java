package day04;
import java.util.Scanner;
public class Guessing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = (int)(Math.random() * 1000 + 1);
		System.out.println("Guessing: ");
		int user_input = scan.nextInt();
		while (user_input != num) {		
			if (user_input == 0) break;
			if (user_input < num) System.out.println("Your number is low!");
			else System.out.println("Your number is too big!");
			System.out.println("Guessing: ");
			user_input = scan.nextInt();
		}
		if (user_input == num) System.out.println("Yes! You get the right number!");
		else System.out.println("See you next time!");
		scan.close();
	}
}