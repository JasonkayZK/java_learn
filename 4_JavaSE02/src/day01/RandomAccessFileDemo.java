package day01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// 0.
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		// 1. write(int 8-bit)
		raf.write(255);
		
		// 2. close()
		raf.close();
		
		// 1'. read()
		RandomAccessFile raf2 = new RandomAccessFile("raf.dat", "r");
		int d = raf2.read();
		System.out.println(d);
		raf2.close();
	}

}
