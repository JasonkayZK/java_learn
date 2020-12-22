package day04Homework;

public class Doctor extends Person {
	private int level;
		
	Doctor() {
		super();
		level = 0;
	}
	
	Doctor(String name, int age, String address, int level) {
		super(name, age, address);
		this.level = level;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("Doctor: " + level);
	}
}
