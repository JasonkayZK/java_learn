package day01;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {

	public static void main(String[] args) {
		File dir = new File(".");
		File[] subs = dir.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				System.out.println("Filtering: " + pathname.getName());
				return !pathname.getName().startsWith(".");
			}
		});
		for (File s : subs) {
			System.out.println(s.getName());
		}
	}

}
