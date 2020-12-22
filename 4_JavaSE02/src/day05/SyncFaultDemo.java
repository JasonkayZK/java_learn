package day05;

public class SyncFaultDemo {

	public static void main(String[] args) {
		final Table table = new Table();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(this.getName() + ":" + bean);
				}
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				while (true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(this.getName() + ":" + bean);
				}
			}
		};
		
		t1.start();
		t2.start();
		
	}

}

class Table {
	private int beans = 20;

// 1. Fault
/*
	public int getBean() {
		if (beans == 0) {
			throw new RuntimeException("There is no bean!");
			
		}
		Thread.yield();
		return beans--;
	}
*/
// 2. synchronized Method	
	public synchronized int getBean() {
		if (beans == 0) {
			throw new RuntimeException("There is no bean!");
			
		}
		Thread.yield();
		return beans--;
	}
	
}
