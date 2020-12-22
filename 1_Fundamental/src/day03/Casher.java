package day03;
import java.util.Scanner;
public class Casher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the price, amount and money:");
		double price = scan.nextDouble();
		double amount = scan.nextDouble();
		double money = scan.nextDouble();
		
		double totalPrice = price * amount;
		if (totalPrice >= 1000) totalPrice *= 0.7;
		else if (totalPrice >= 999) totalPrice *= 0.8;
		else totalPrice *= 0.9;
		double change = money - totalPrice;
		System.out.println("The money should be paid: " + totalPrice);
		if (change >= 0) System.out.println("The change: " + change);
		else System.out.println("The money is not enough!");
		scan.close();
	}

}
