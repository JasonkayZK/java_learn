package day03;
import java.util.Scanner;
public class ScoreLevel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the score");
		int score = scan.nextInt();
		if (score < 0 || score > 100) System.out.println("Invalid Score!");
		else if (score >= 90) System.out.println("A");
		else if (score >= 80) System.out.println("B");
		else if (score >= 60) System.out.println("C");
		else System.out.println("D");			

		scan.close();
	}

}
