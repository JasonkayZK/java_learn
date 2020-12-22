package day04Homework;

public class Student extends Person {
	private String className;
	
	Student() {
		super();
		className = new String();
	}
	
	Student(String name, int age, String address, String className) {
		super(name, age, address);
		this.className = className;
	}
	
	@Override
	public void show() {
		super.show();
		System.out.println("Student: " + className);
	}
}
