package day03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISRDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("osw.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		
		int d = -1;
		while ((d = isr.read()) != -1) {
			System.out.print((char)d);
		}
		
		isr.close();
	}

}
