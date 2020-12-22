package day06_Homework;

public class UnionPayTest {

	public static void main(String[] args) {
		UnionPay abc = new CCBImpl("12345", 1000);
		ABCATM atm = new ABCATM();
	
		atm.insertCard(abc);
		atm.payTelBill("12345678901", 1232);
	}

}
