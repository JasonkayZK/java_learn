package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Homework {

	public static void main(String[] args) throws ParseException {
		// 2.
		Scanner scan = new Scanner(System.in);
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date nowDate = now.getTime();
		System.out.println(sdf.format(nowDate));
		
		// 3.
		String birth = scan.nextLine();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = sdf.parse(birth);
		Calendar birthCal = Calendar.getInstance();
		birthCal.setTime(birthDate);
		long passedSecond = (nowDate.getTime() - birthDate.getTime()) / 1000;
		System.out.println("You have passed " + (passedSecond / (60 * 60 * 24 * 7)) + " weeks!");
		System.out.println("You hava passed " + (passedSecond / (60 * 60 * 24)) + " days!");
		
		// 4.
		String produce = scan.next();
		int quality = scan.nextInt();
		Date produceDate = sdf.parse(produce);
		Calendar produceCal = Calendar.getInstance();
		produceCal.setTime(produceDate);

		produceCal.add(Calendar.DAY_OF_YEAR, quality - 14);
		// US week begins with Sunday:
		if (produceCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			produceCal.add(Calendar.DAY_OF_YEAR, -1);
		}
		produceCal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		
		System.out.println(produceCal.getTime());
		
		// 5.
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		System.out.println(c.size());
		System.out.println(c.contains("four"));
		System.out.println(c.isEmpty());
		c.clear();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
		scan.close();
	}

}
