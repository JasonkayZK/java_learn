package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OSWDemo {

	public static void main(String[] args) throws IOException {
		// 1. OutputStreamWriter
		FileOutputStream fos = new FileOutputStream("osw.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		
		osw.write("Hello");
		osw.write("world!");
		System.out.println("Write finished!");
		osw.close();
		
	}

}
