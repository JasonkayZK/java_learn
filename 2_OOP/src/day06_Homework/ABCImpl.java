package day06_Homework;

public class ABCImpl implements ABC {
	private String password;
	private double balance;
	
	ABCImpl() {
		this("", 0);
	}
	
	ABCImpl(String pwd, double money) {
		this.password = pwd;
		this.balance = money;
	}
	
	@Override
	public boolean checkPwd(String pwd) {
		return this.password.equals(pwd);
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public boolean withdrawMoney(double money) {
		if (this.balance - money >= 0) {
			this.balance -= money;
			return true;
		}
		return false;
	}

	@Override
	public boolean payTelBill(String num, double money) {
		if (num.length() == 11 && this.balance - money >= 0) {
			this.balance -= money;
			return true;
		}
		return false;
	}

}
