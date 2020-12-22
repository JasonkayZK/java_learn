package day02;

import java.io.FileInputStream;
import java.io.IOException;

public class FISDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] buf = new byte[100];
		int len = fis.read(buf);
		String str = new String(buf, 0, len, "UTF-8");
		System.out.println(str);
		fis.close();
	}

}
