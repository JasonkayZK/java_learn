package day03;
import java.util.Scanner;
public class AccumulationExt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the number: ");
		int n = scan.nextInt();
		int res = 0;
		for (int i = 1; i <= n; ++i) res += i % 2 == 0 ? i : 0;
		System.out.println("The answer is: " + res);
		System.out.println("The factor of " + n + " are:");
		for (int i = 1; i <= n; ++i)
			if (n % i == 0)
				System.out.println(i);
		scan.close();
	}

}
