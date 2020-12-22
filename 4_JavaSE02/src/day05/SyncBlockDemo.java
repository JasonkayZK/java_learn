package day05;

public class SyncBlockDemo {

	public static void main(String[] args) {
		final Shop shop = new Shop();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				shop.buy();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
		
	}
	
}

class Shop {
	public void buy() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName() + ":" + " Choose Cloth!");
			Thread.sleep(5000);
			
			synchronized (this) {
				System.out.println(t.getName() + ":" + " Try Cloth!");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName() + ":" + " Pay and leave!");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
