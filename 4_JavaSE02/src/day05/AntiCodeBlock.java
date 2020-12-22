package day05;

public class AntiCodeBlock {

	public static void main(String[] args) {
		final Boo boo = new Boo();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				boo.methodA();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				boo.methodB();
			}
		};
		
		t1.start();
		t2.start();
		
	}
}

class Boo {
	public synchronized void methodA() {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + ":" + "Run methodA!");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName() + ":" + "Finish methodA!");
	}
	
	public void methodB() {
		synchronized (this) {
			Thread t = Thread.currentThread();
			System.out.println(t.getName() + ":" + "Run methodB!");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(t.getName() + ":" + "Finish methodB!");
		}
	}
	
}




