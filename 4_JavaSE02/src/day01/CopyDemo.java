package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("src.png", "r");
		RandomAccessFile desc = new RandomAccessFile("desc.png", "rw");
		int d = -1;
		long start = System.currentTimeMillis();
		while ((d = src.read()) != -1) {
			desc.write(d);
		}
		long end = System.currentTimeMillis();
		System.out.println("Copy Finished! Cost Time: " + (end - start) + "ms.");
		src.close();
		desc.close();
	}

}
