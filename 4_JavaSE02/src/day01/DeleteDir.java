package day01;

import java.io.File;

public class DeleteDir {

	public static void main(String[] args) {
		File file = new File("a");
		delete(file);
	}
	
	public static void delete(File file) {
		if (file.isDirectory()) {
			File[] subs = file.listFiles();
			for (File sub : subs) {
				delete(sub);
			}
		}
		file.delete();
	}

}
