package day01;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Homework {

	public static void main(String[] args) throws IOException {
/*
		// 1. 
		File dir = new File(".");
		FileFilter filter = new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".jar");
			}
		};
		showJar(dir, filter);
		
		// 2. 
		byte[] buf = new byte[1024 * 10];
		RandomAccessFile src = new RandomAccessFile("demo.txt", "r");
		RandomAccessFile desc = new RandomAccessFile("demo_cp.txt", "rw");
		int len = -1;
		long start = System.currentTimeMillis();
		while ((len = src.read(buf)) != -1) {
			desc.write(buf, 0, len);
		}
		long end = System.currentTimeMillis();
		System.out.println("Copy finished. Cost Time: " + (end - start) + "ms.");
		src.close();
		desc.close();
*/
		// 3.
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		byte[] buff = new byte[7];
		raf.seek(0);
		raf.skipBytes(8);
		raf.read(buff);
		System.out.println(new String(buff)); // NEWYORK
		raf.close();
	}
	
	private static void showJar(File dir, FileFilter filter) {
		if (dir.isDirectory()) {
			File[] subs = dir.listFiles();
			for (int i = 0; i < subs.length; ++i) {
				showJar(subs[i], filter);
			}
		}
		if (filter.accept(dir)) {
			System.out.println(dir.getName());
		}
	}

}
