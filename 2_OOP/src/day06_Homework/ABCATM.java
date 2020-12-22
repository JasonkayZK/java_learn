package day06_Homework;

public class ABCATM {
	private UnionPay card;	
	
	public void insertCard(UnionPay card) {
		this.card = card;
	}	
	
	public void payTelBill(String num, double money) {
		if (this.card instanceof ABC) {
			if (((ABC)(this.card)).payTelBill(num, money)) {
				System.out.println("Success to pay the bill");
			} else {
				System.out.println("Fail to pay");
			}
		} else {
			System.out.println("This card does not have the function: payOnline!");
		}
	}
	
}
