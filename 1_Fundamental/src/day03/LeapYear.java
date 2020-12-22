package day03;
import java.util.Scanner;
public class LeapYear {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the year:");
		int year = scan.nextInt();
		System.out.println(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
		scan.close();
	}

}

