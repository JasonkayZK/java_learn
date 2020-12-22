package day01;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) throws IOException {
/*	
		File file = new File("." + File.separator + "demo.txt");
	
		// 1. String getName()
		System.out.println(file.getName());
		
		// 2. long length()
		System.out.println(file.length());
		
		// 3. boolean canRead, canWrite, canExecute
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		System.out.println(file.canExecute());
		
		// 4. boolean isHidden()
		System.out.println(file.isHidden());
				
		// 5. boolean exists()
		// 	  createNewFile()
		File newFile = new File("." + File.separator + "test.txt");
		if (!newFile.exists()) {
			newFile.createNewFile();
			System.out.println("Create new file!");
		} else {
			System.out.println("File exists!");
		}
		
		// 6. delete()
		if (newFile.exists()) {
			newFile.delete();
			System.out.println("Deleted");
		} else {
			System.out.println("File do not exist");
		}
				
		// 7. mkdir()
		File dir = new File("Demo");
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("Create dir");
		} else {
			System.out.println("Dir existed");
		}
		// 8. mkdirs()
		dir = new File("a" + File.separator + "b" + File.separator + "c");
		if (!dir.exists()) {
			dir.mkdirs();
			System.out.println("Create dir");
		} else {
			System.out.println("Dir existed");
		}
		
		// 9. delete Dir
		dir = new File("a");
		if (dir.exists()) {
			dir.delete();
			System.out.println("Delete file");
		} else {
			System.out.println("File do not exist");
		}

		// 10. boolean isFile()
		//	   boolean isDirectory()
		// 	   File[] listFiles()
		File dir = new File(".");
		File[] subs = dir.listFiles();
		for (File f : subs) {
			if (f.isFile()) {
				System.out.print("File: ");
			} else {
				System.out.print("Dir: ");
			} 
			System.out.println();
		}
*/
		
	}
}




