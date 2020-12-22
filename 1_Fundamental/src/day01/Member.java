package day01;
import java.util.Scanner;
public class Member {

	public static void main(String[] args) {
		System.out.println("Please input the first name:");
		Scanner scan = new Scanner(System.in);
		String first = scan.next();
		System.out.println("Please input the second name:");
		String second = scan.next();
		System.out.println(first + " and " + second);
		scan.close();
	}

}
