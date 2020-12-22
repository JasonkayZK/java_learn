package day01;

public class Student {
	String name;
	int age;
	String address;
	
	public void eat() {
		System.out.println(name + " is eating");
	}
	
	public void sayHi() {
		System.out.println("Hi, this is " + name + ", i am " + age + " years old." + " And i came from " + address);
	}
}
