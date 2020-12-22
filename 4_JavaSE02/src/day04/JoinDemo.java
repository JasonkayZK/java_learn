package day04;

public class JoinDemo {

	public static boolean isFinish = false;
	
	public static void main(String[] args) {
		final Thread download = new Thread() {
			@Override
			public void run() {
				System.out.println("down: start download" );
				for (int i = 1; i < 100; ++i) {
					System.out.println("down: " + i + "%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {

					}
				}
				System.out.println("down: download finished");
				isFinish = true;
			}
		};
		
		Thread show = new Thread() {
			@Override
			public void run() {
				System.out.println("Show: start to print graph!");
				
				try {
					download.join();
				} catch (InterruptedException e) {

				}
				
				if (!isFinish) {
					throw new RuntimeException("Graph is not downloaded!");
				}
				System.out.println("show: show the graph!");
			}
		};
		
		show.start();
		download.start();
		
		
	}
}

