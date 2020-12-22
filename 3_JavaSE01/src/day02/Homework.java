package day02;

import java.util.Scanner;

public class Homework {
	
	public static void main(String[] args) {
		// 1. 
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String regInt = "[\\d]+";
		String regDou = "[\\d]+(.)?[\\d]+";
		if (str.matches(regInt)) {
			System.out.println(Integer.parseInt(str) * 10);
		} else if (str.matches(regDou)) {
			System.out.println(Double.parseDouble(str) * 5);
		} else {
			System.out.println("Not Number");
		}
		
		// 2.
		String reg = ",";
		str = "123,456,789,012";
		String[] arr = str.split(reg);
		for (String s : arr) {
			System.out.println(s);
		}
		
		// 3.
		reg = "[a-zA-Z]+";
		str = "123abc456def789ghi";
		System.out.println(str.replaceAll(reg, "#char#"));
		
		// 4.
		Person p1 = new Person("ZS", 25, 5000);
		System.out.println(p1);
		Person p2 = new Person("ZS", 33, 5555);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		
		scan.close();
	}
}

class Person {
	private String name;
	private int age;
	private int salary;
	
	Person(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.age + ", " + this.salary; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		} 
		if (obj instanceof Person) {
			return this.name.equals(((Person) obj).getName());
		}
		return false;
	}
}






