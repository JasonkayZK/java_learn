package day04Homework;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.show();
		
		Student s1 = new Student("zk", 18, "pds", "c1");
		s1.show();
		
		Teacher t1 = new Teacher("zk", 13, "pds", 3000.3);
		t1.show();
		
		Doctor d1 = new Doctor("zk", 14, "pds", 2);
		d1.show();

	}

}
