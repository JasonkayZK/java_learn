package day02;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;
	private String name;
	private double salary;
	private String gender;
	private transient List<String> otherInfo;
	
	public Person() {
		
	}
	
	public Person(int age, String name, double salary, String gender, List<String> otherInfo) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", otherInfo="
				+ otherInfo + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}
	
}
