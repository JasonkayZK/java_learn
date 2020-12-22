package day06;

public class MulTypeDemo {

	public static void main(String[] args) {
		Aoo o1 = new Boo();
		Boo o2 = (Boo)o1;
		Inter1 o3 = (Inter1) o1;
		//Coo o4 = (Coo)o1;
		if (o1 instanceof Coo) {
			Coo o4 = (Coo)o1;
		}
	}

}

interface Inter1 { }
class Aoo {}
class Boo extends Aoo implements Inter1 {}
class Coo extends Aoo {}
