package day03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/** 
 * ��ɼ��±�����
 * Ҫ��
 * ��������֮�� �û�����һ���ļ�����
 * Ȼ�󴴽����ļ��� ֮�������û���ʼ�������ݣ�
 * �����û������ÿһ�ж�����д���ļ���/
 * ���û�����"exit"ʱ�� �˳�����
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











