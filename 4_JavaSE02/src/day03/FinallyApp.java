package day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FinallyApp {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("src/day03/FinallyApp.java")));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("Unknown error uccured!");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					System.out.println("Unable to close BufferedReader!");
				}
			}
		}
	}

}
