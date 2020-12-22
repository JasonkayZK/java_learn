package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo2 {

	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("src.png", "r");
		RandomAccessFile desc = new RandomAccessFile("desc.png", "rw");
		byte[] buf = new byte[1024 * 10];
		int len = -1;
		long start = System.currentTimeMillis();
		while ((len = src.read(buf)) != -1) {
			desc.write(buf, 0, len);
		}
		long end = System.currentTimeMillis();
		System.out.println("Copy Finished! Cost Time: " + (end - start) + "ms.");
		
		src.close();
		desc.close();
	}

}
