package day01;

public class StudentTest {

	public static void main(String[] args) {
		Student stu1 = new Student();
		stu1.name = "Zk1";
		stu1.age = 18;
		stu1.address = "PingD";
		stu1.eat();
		stu1.sayHi();
		
		Student stu2 = new Student();
		stu2.name = "Zk2";
		stu2.age = 11;
		stu2.address = "Ddass";
		stu2.eat();
		stu2.sayHi();

		Student stu3 = new Student();
		stu3.name = "Zk3";
		stu3.age = 15;
		stu3.address = "asdfgasd";
		stu3.eat();
		stu3.sayHi();
	}

}
