package day01;

import java.util.Scanner;

/** 
 * input: 
 * www.baidu.com
 * www.baidu.com.cn
 * http://www.baidu.com
 * 
 * return: baidu
 * @author ZK
 *
 */
public class Test01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		int startIndex = -1;
		int endIndex = -1;
		startIndex = input.indexOf('.') + 1;
		endIndex = input.indexOf('.', startIndex );
		String result = input.substring(startIndex, endIndex);
		System.out.println(result);
		scan.close();
	}

}
