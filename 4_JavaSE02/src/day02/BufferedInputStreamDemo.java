package day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("a_cp.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int d = -1;
		while ((d = bis.read()) != -1) {
			bos.write(d);
		}
		System.out.println("Copy finished!");
		bis.close();
		bos.close();
		
	}

}
