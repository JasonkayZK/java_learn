package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {

	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		System.out.println(now);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(now));
		
		String str = "2018-08-08 12:23:11";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDate = sdf.parse(str);
		System.out.println(myDate);
		
	}

}
