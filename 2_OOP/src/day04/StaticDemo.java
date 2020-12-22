package day04;

public class StaticDemo {

	public static void main(String[] args) {
		Loo o1 = new Loo();
		o1.show();
		Loo o2 = new Loo();
		o2.show();
		System.out.println(Loo.b);
		
		Moo.test();
		
		Noo o3 = new Noo();
		Noo o4 = new Noo();
	}

}

class Noo {
	static {
		System.out.println("Static block");
	}
	
	Noo() {
		System.out.println("Construct Method");
	}
}


class Moo {
	int a;
	static int b;
	
	void show() {
		a = 1;
		b = 2;		
	}
	
	static void test() {
		//a = 1;
		b = 2;
	}
}

class Loo {
	int a;
	static int b;
	
	Loo() {
		a++;
		b++;
	}
	
	public void show() {
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}

