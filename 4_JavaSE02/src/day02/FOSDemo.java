package day02;

import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("fos.txt");
		String str = "abcdsf";
		byte[] buf = str.getBytes("UTF-8");
		fos.write(buf);
		
		fos.close();
		
		fos = new FileOutputStream("fos.txt", true);
		str = "safasdfHelloWorld";
		buf = str.getBytes("utf-8");
		fos.write(buf);
		fos.close();
	}

}
