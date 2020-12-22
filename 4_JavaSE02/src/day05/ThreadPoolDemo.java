package day05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		// 0. Create
		ExecutorService threadPool1 = Executors.newFixedThreadPool(4);
		
		for (int i = 0; i < 5; ++i) {
			Runnable runn = new Runnable() {
				@Override
				public void run() {
					
					Thread t = Thread.currentThread();
					System.out.println(t + ": Running!");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println(t + ": Thread is interrupted!");
					}
					System.out.println(t + ": Finished!");
					
				} 
			};
			threadPool1.execute(runn);
			System.out.println("Assign a task to the thread pool!");
		}
		
		threadPool1.shutdown();
//		threadPool1.shutdownNow();
		
	}

}
