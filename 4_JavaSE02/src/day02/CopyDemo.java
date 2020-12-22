package day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		FileOutputStream fos = new FileOutputStream("fos_cp.txt");
		
		byte[] buf = new byte[1024 * 10];
		int len = -1;
		while ((len = fis.read(buf)) != -1) {
			fos.write(buf);
		}
		fis.close();
		fos.close();
	}

}
