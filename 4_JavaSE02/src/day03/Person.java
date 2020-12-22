package day03;

public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalAgeException {
		if (age < 0 || age > 100) {
			throw new IllegalAgeException("Invalid age!");
		}
		this.age = age;
	}
	
	
}
