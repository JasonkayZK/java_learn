package day04;

public class Hoo {
	public int a;
	protected int b;
	int c;
	private int d;
	
	public void show() {
		a = 1;
		b = 2;
		c = 3;
		d = 4;
	}
}

class Ioo {
	
	public void show() {
		Hoo o = new Hoo();
		o.a = 4;
		o.b = 3;
		o.c = 2;
		//o.d = 1;
		
	}
}