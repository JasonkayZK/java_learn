package day02;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the age:");
		int age = scan.nextInt();
		System.out.println(age);
		scan.close();
	}

}
