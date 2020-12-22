package day04Homework;

public class Person {
	private String name;
	private int age;
	private String address;
	
	Person() {
		this("", 0, "");
	}
	
	Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void show() {
		System.out.println("name: " + name 
				+ ", age: " + age 
				+ ", address: " + address);		
	}
}
