package day04;

public class OverrideDemo {

	public static void main(String[] args) {
		Goo goo = new Goo();
		Eoo o = new Foo();
		goo.test(o);

	}

}

class Goo {
	
	void test(Eoo o) {
		System.out.println("Father parameter");
		o.show();
	}
	
	void test(Foo o) {
		System.out.println("Children parameter");
		o.show();
	}
}


class Eoo {
	public void show() {
		System.out.println("Parent show");
	}
}

class Foo extends Eoo {
	
	public void show() {
		System.out.println("Children show");
	}
}
