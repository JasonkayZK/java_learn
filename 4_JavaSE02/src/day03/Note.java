package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * 完成记事本功能
 * 要求：
 * 程序启动之后， 用户输入一个文件名，
 * 然后创建该文件， 之后提醒用户开始输入内容，
 * 并将用户输入的每一行都按行写入文件中/
 * 当用户输入"exit"时， 退出程序
 * 
 * @author ZK
 *
 */
public class Note {

	public static void main(String[] args) throws IOException {
		System.out.println("Please input filename: ");
		Scanner scan = new Scanner(System.in);
		String filename = scan.nextLine();
		
		FileOutputStream fos = new FileOutputStream(filename);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw = new PrintWriter(osw, true);
		
		String input = null;
		System.out.println("Start to write: ");
		while (true) {
			input = scan.nextLine();
			if ("exit".equals(input)) {
				System.out.println("Thanks for using!");
				break;
			}
			pw.println(input);
		}
		System.out.println("Write finished!");
		scan.close();
		pw.close();
	}

}











