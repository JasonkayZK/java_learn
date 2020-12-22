package day06;

public class MethodDemo {

	public static void main(String[] args) {
		say();
		sayHi("Zhangkai");
		double a = getNum();
		System.out.println(a);
		int x = 1, y = 2;
		System.out.println("x + y = " + sum(x, y));
	}
	public static void say() {
		System.out.println("Hello, my name is ZK");
	}
	public static void sayHi(String name) {
		System.out.println("Hello, " + name);
	}
	public static double getNum() {
		return 8.88;
	}
	public static int sum (int x, int y) {
		return x + y;
	}
}
