package day03;
import java.util.Scanner;
public class Age {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the age:");
		int age = scan.nextInt();
		System.out.println(age >= 18 && age <= 50);
		scan.close();
	}
	
}
