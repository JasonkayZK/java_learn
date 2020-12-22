package day04;

public class DaemonDemo {

	public static void main(String[] args) {
		Thread rose = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; ++i) {
					System.out.println("Rose: Let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
				System.out.println("Ahhhhhhhhhhhhhhhhh..........!");
			}
		};
		
		Thread jack = new Thread() {
			@Override
			public void run() {
				while (true) {
					System.out.println("Jack: you jump, i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
				}
			}
		};
		
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
//		System.out.println("Main Thread finished!");
		while (true);
		
	}

}
