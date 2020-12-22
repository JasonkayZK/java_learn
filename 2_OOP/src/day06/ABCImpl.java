package day06;

public class ABCImpl implements ABC {
	String password;
	double balance;
	
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
		if (this.balance - money >= -2000) {
			this.balance -= money;
			return true;
		}
		return false;
	}

	@Override
	public boolean payTelBill(String pwd, double money) {
		if (pwd.length() == 11 && this.balance - money >= -2000) {
			this.balance -= money;
			return true;
		}
		return false;
	}

}
