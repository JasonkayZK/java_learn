package day04;
import java.util.Scanner;
public class SumofSeq2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double res = 0;
		int user_input = scan.nextInt(); 
		for (int i = 1; i <= user_input; ++i)
			res += 1.0 / i;
		System.out.println("The result is: " + res);
		scan.close();
	}

}
