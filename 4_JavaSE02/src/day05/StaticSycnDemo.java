package day05;

public class StaticSycnDemo {

	public static void main(String[] args) {
		final Foo f1 = new Foo();
		final Foo f2 = new Foo();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				f1.dosome();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				f2.dosome();
			}
		};
		
		t1.start();
		t2.start();
		
	}

}

class Foo {
	public static synchronized void dosome() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + ":" + "run dosome");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}
		
		System.out.println(t.getName() + ":" + "finish dosome");
		
	}
}