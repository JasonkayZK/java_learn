package day04;

public class ThreadInnerClassDemo {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("Who are you?");
				}
			}
		};
		t1.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; ++i) {
					System.out.println("My name is Jasonkay!");
				}
			}
		}).start();
	}

}
