package day04Homework;

public class Teacher extends Person {
	private double salary;
	
	Teacher() {
		super();
		salary = 0.0;
	}
	
	Teacher(String name, int age, String address, double salary) {
		super(name, age, address);
		this.salary = salary;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("Teacher: " + salary);
	}
}
