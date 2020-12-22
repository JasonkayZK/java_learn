package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/day03/BufferedReaderDemo.java");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}

}
 
