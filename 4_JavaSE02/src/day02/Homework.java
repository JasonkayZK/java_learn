package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Homework {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 3. 4.
/*		
		FileInputStream fis = new FileInputStream("person.obj");
		FileOutputStream fos = new FileOutputStream("." + File.separator + "src" + File.separator + "person.obj");
		File file = new File("person.obj");
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		if (file.exists()) {
			int d = -1;
			while ((d = bis.read()) != -1) {
				bos.write(d);
			}
			System.out.println("Copy Finished!");
		} else {
			System.out.println("File not found!");
		}
		System.out.println("Move Finished");
		file.deleteOnExit();
		bis.close();
		bos.close();
*/
		// 5. 
		List<Emp> empList = new ArrayList<Emp> ();
		List<String> info = new ArrayList<String> ();
		info.add("Good worker!");
		info.add("good boy!");
		empList.add(new Emp("ZK", 22, "Man", 2000.5, info));
		empList.add(new Emp("ZK2", 22, "Man2", 20002.5, info));
		empList.add(new Emp("ZK3", 22, "Man3", 20003.5, info));
		empList.add(new Emp("ZK4", 22, "Man4", 20004.5, info));
		
		FileOutputStream fos = new FileOutputStream("empList.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
		// Write
		for (Emp emp : empList) {
			oos.writeObject(emp);
		}
		System.out.println("Write Finished!");
		oos.writeObject(null);
		oos.close();

		empList.clear();

		// Read
		FileInputStream fis = new FileInputStream("empList.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = null;
		while ((obj = ois.readObject()) != null) {
			empList.add((Emp)obj);
		}
		
		// Traverse
		for (Emp emp : empList) {
			System.out.println(emp);
		}
		ois.close();
	
		
	}

}
