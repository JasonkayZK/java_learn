package day03;

import java.util.Date;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		
		Date date = calendar.getTime();
		System.out.println(date);
		
		
		// Tomorrow
		date.setTime(date.getTime() + 1000 * 60 * 60 * 24);
		System.out.println(date);
		
		// SetTime
		calendar.setTime(date);
		System.out.println(calendar.getTime());
		
		calendar.set(Calendar.YEAR, 2008);
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		calendar.set(Calendar.HOUR_OF_DAY, 20);
		calendar.set(Calendar.MINUTE, 8);
		calendar.set(Calendar.SECOND, 8);
		
		//calendar.set(2008, 7, 8, 20, 8, 8);
		System.out.println(calendar.getTime());
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		System.out.println(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + min + ":" + sec);
		
		calendar = Calendar.getInstance();
		// Day_Of_Week
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("Week: " + (dow == 1 ? 7 : dow - 1));
		String[] data = {"日", "一", "二", "三", "四", "五", "六"};
		System.out.println("周" + data[dow - 1]);
		
		// DAY_OF_YEAR
		System.out.println("This year has already passed: " + calendar.get(Calendar.DAY_OF_YEAR));
		
		// getActualMaxumun
		// DAY_OF_MONTH_MAX
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		
		int dayInYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(dayInYear);
		
		// void add(int field, int value)
		// 2 years & 2 months after
		calendar.add(Calendar.YEAR, 2);
		calendar.add(Calendar.MONTH, 2);
		System.out.println(calendar.getTime());
		
		// 8 days later
		calendar.add(Calendar.DAY_OF_YEAR, 8);
		System.out.println(calendar.getTime());
		
	}

}
