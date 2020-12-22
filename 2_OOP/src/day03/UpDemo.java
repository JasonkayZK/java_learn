package day03;

public class UpDemo {

	public static void main(String[] args) {
		Coo o1 = new Doo();
		o1.a = 1;
		o1.say();
		// o1.d = 2;

	}

}

class Coo {
	int a;

	public void say() {}
}

class Doo extends Coo {
	int d;
	public void say() {}
}

