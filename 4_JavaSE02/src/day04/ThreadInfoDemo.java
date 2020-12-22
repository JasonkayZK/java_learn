package day04;

public class ThreadInfoDemo {

	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		// 1. long getId();
		System.out.println(main.getId());
		
		// 2. String getName();
		System.out.println(main.getName());
		
		// 3. int getPriority()
		System.out.println(main.getPriority());
		
		// 4. boolean isAlive()
		System.out.println(main.isAlive());
		
		// 5. boolean isDaemon()
		System.out.println(main.isDaemon());
		
		// 6. boolean isInterrupted()
		System.out.println(main.isInterrupted());
		
		
		
		
	}

}
