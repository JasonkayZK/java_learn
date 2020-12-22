package day06;

public class ICBCImpl implements ICBC {
	String password;
	double balance;
	
	ICBCImpl() {
		this("", 0.0);
	}
	
	ICBCImpl(String pwd, double money) {
		this.password = pwd;
		this.balance = money;
	}
	
	@Override
	public boolean checkPwd(String pwd) {
		return password.equals(pwd);
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
	public void payOnline(double money) {
		if (this.balance - money >= 0)
			this.balance -= money;
	}

}
