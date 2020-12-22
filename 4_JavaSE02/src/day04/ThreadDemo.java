package day04;

public class ThreadDemo {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		
		t1.start();
		t2.start();
		
	}
}

class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; ++i) {
			System.out.println("Who are you?");
		}
	}
	
}

class MyThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; ++i) {
			System.out.println("I am Jasonkay!");
		}
	}
}


