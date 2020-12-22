package day05;
import java.util.Scanner;
public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the number: 2~");
		int user_input = scan.nextInt();
		int num = 0;
		for (int i = 2; i <= user_input; ++i) {
			boolean flag = true;
			for (int j = 2; j < Math.sqrt(i); ++j) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				num++;
				if (num % 10 == 0) System.out.println(i);
				else System.out.print(i + "\t");
			}
		}
		System.out.println();
		System.out.println("The total number of prime is: " + num);
		scan.close();
	}

}
