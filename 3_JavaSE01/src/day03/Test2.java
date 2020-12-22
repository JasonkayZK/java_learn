package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** 
 * 用户输入自己的生日， 格式：
 * 1992-07-13
 * 经过计算， 输出：
 * 到今天为止一共活了xxxx天。
 * 以及距离10000天还有多少天。
 * 生存10000天的纪念日是：2018-12-05
 * @author ZK
 *
 */
public class Test2 {

	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		Scanner scan = new Scanner(System.in);
		String birth = scan.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = sdf.parse(birth);
		
		// Calculate days that has lived
		long time = now.getTime() - birthDate.getTime();
		time = time/1000/60/60/24;
		System.out.println("You have liven " + time + " days. Keep Trying!");
		
		System.out.println("Last " + (10000 - time) + " to live 10000 days");
		
		time = now.getTime();
		time += 10000 * 1000 * 24 * 60 * 60;
		Date aniver = new Date(time);
		
		System.out.println("The 10000 days aniversary is at: " + aniver);
		
		
		
		
		
		scan.close();
	}

}
