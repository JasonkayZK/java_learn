package day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BufferedOSDemo {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		bos.write("Haha".getBytes("UTF-8"));
		System.out.println("Write finished!");
		bos.flush();
		bos.close();
	}

}
