package day06;

public class UnionPayTest {

	public static void main(String[] args) {
		ABCATM atm = new ABCATM();
		UnionPay card = new ABCImpl();
		atm.insertCard(card);
		atm.payTelBill("12345678911", 10.0);
	}

}

class ABCATM {
	private UnionPay card;
	public void insertCard(UnionPay card) {
		this.card = card;
		System.out.println(this.card.getBalance());
	}
	
	public void payTelBill(String pwd, double price) {
		if (this.card instanceof ABC) {
			if (((ABC)(this.card)).payTelBill(pwd, price)) {
				System.out.println("Success to pay!");
			} else {
				System.out.println("Fail to pay!");
			}
		} else {
			System.out.println("The card type is not ABC, fail to pay!");
		}
	}
}







