package day03;
import java.util.Scanner;
public class CommandBySwitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the command: 1.Show all logs 2. Show login logs 3. exit");		
		int command = scan.nextInt();
		switch(command) {
		case 1:
			System.out.println("Show all logs");
			break;
		case 2:
			System.out.println("Show login logs");
			break;
		case 0:
			System.out.println("Exit");
			break;
		default:
			System.out.println("Invalid Command");
		}
		scan.close();
	}

}
