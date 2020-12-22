package day06_Homework;

public class CCBImpl implements CCB {
	private String password;
	private double balance;
	
	CCBImpl() {
		this("", 0);
	}
	
	CCBImpl(String pwd, double money) {
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
		if (this.balance - money >= -2000) {
			this.balance -= money;
			return true;
		}
		return false;
	}

	@Override
	public boolean payGasBill(double money) {
		if (this.balance - money >= 0) {
			this.balance -= money;
			return true;
		}
		return false;
	}
	
	
}
