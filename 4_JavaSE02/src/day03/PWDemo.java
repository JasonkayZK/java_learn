package day03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PWDemo {

	public static void main(String[] args) throws FileNotFoundException {
		// 1. Normal 
		PrintWriter pw = new PrintWriter("pw.txt");
		
		pw.println("Helloworld!");
		pw.println("Skr!");
		System.out.println("Write finished");
		pw.close();
		
		// 2. Other stream
		FileOutputStream fos = new FileOutputStream("pw1.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		pw = new PrintWriter(osw);
		pw.println("Haha");
		pw.println("Hehe");
		System.out.println("Write finished");
		pw.close();
	}

}
