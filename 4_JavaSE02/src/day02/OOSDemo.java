package day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class OOSDemo {

	public static void main(String[] args) throws IOException {
		Person p = new Person();
		p.setName("ZK");
		p.setGender("Man");
		p.setAge(22);
		p.setSalary(1000.2);
		List<String> otherInfo = new ArrayList<String> ();
		otherInfo.add("a Student");
		otherInfo.add("Good Boy");
		otherInfo.add("Handsome!");
		p.setOtherInfo(otherInfo);
		
		FileOutputStream fos = new FileOutputStream("person.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(p);
		System.out.println("Write Finished!");
		oos.close();
	}

}
