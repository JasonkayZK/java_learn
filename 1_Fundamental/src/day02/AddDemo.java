package day02;
import java.util.Scanner;
import java.util.Random;
public class AddDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int a = r.nextInt();
		int b = r.nextInt();
		System.out.println(a + " + " + b + " = ?");
		int user_ans = scan.nextInt();
		if (user_ans == a + b) {
			System.out.println("Correct!");
		} else {
			System.out.println("False!");
		}
		scan.close(); 
	}

}
