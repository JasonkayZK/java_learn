package day05;
import java.util.Scanner;
public class UnionPayTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UnionPay icbc = new ICBCImpl(1000, "1234");
		//UnionPay abc = new ABCImpl(0, "123");
		
		System.out.println("Please input the password: ");
		if (icbc.checkPwd(scan.next())) {
			System.out.println("Please input the number of the money: ");
			double num = scan.nextDouble();
			if (icbc.WithdrawMoney(num)) {
				System.out.println("Success to withdraw the money, "
						+ "the remain: " + icbc.getBalance());				
			} else {
				System.out.println("Fail to withdraw the money");			
			}
		} else {
			System.out.println("Wrong password, fail to login!");
		}		
		
		scan.close();
	}

}

interface UnionPay {
	public boolean WithdrawMoney(double number);
	public double getBalance();
	public boolean checkPwd(String input);
	
}

interface ICBC extends UnionPay {
	public void payOnline(double number);
}

interface ABC extends UnionPay {
	public boolean payTelBill(String phoneNum, double sum);
}

class ICBCImpl implements ICBC {
	private double money;
	private String pwd;
	
	ICBCImpl(double money, String pwd) {
		this.money = money;
		this.pwd = pwd;
	}

	@Override
	public boolean WithdrawMoney(double number) {
		if (money - number >= 0) {
			this.money -= number;
			return true;
		}
		return false;
	}

	@Override
	public double getBalance() {
		return this.money;
	}

	@Override
	public boolean checkPwd(String input) {
		return (this.pwd.equals(input));
	}

	@Override
	public void payOnline(double number) {
		if (this.money > number) {
			this.money -= number;
		}
		
	}
}

class ABCImpl implements ABC {
	private double money;
	private String pwd;
	
	ABCImpl(double money, String pwd) {
		this.money = money;
		this.pwd = pwd;
	}
	
	
	@Override
	public boolean WithdrawMoney(double number) {
		if ((this.money - number) >= -2000) {
			this.money -= number;
			return true;
		}
		return false;
	}

	@Override
	public double getBalance() {
		return this.money;
	}

	@Override
	public boolean checkPwd(String input) {
		return this.pwd.equals(input);
	}

	@Override
	public boolean payTelBill(String phoneNum, double sum) {
		if (phoneNum.length() == 11 && (this.money - sum) >= -2000) {
			this.money -= sum;
			return true;
		}
		return false;
	}
	
}











