package day02;

import java.io.Serializable;
import java.util.List;

public class Emp implements Serializable {
	/**
	 * @serial Ver: 1.0
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	private double salary;
	private List<String> otherInfo;
	
	public Emp() {
		
	}
	
	public Emp(String name, int age, String gender, double salary, List<String> otherInfo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.otherInfo = otherInfo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(List<String> otherInfo) {
		this.otherInfo = otherInfo;
	}

	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", gender=" + gender + ", salary=" + salary + ", otherInfo="
				+ otherInfo + "]";
	}
	
}
