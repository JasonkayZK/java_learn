package day03;

public class ThrowDemo {

	public static void main(String[] args) {
		Person p = new Person();
//		try {
//			p.setAge(200);	
//		} catch (Exception e) {
//			System.out.println("Please input the right age: 0 - 100!");
//		}
		try {
			p.setAge(200);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
		System.out.println(p.getAge());
		
	}

}
