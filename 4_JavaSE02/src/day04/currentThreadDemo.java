package day04;

public class currentThreadDemo {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("Run main thread: " + main);
		
		dosome();
		
		Thread t = new Thread() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("Run mythread: " + t);
				dosome();
			}
			
		};
		t.start();
		
	}

	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("Run dosome thread: " + t);
	}
}

