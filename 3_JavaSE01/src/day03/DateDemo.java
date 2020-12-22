package day03;

import java.util.Date;

public class DateDemo {
/**
 * java.util.Date
 * Date 中的每一个实例用来表示一个确切的时间点；
 * 内部维护了一个long， 表示自：
 * 1970/01/01 - now的毫秒数
 * 存在设计缺陷
 */
	public static void main(String[] args) {
		Date now = new Date();
	
		System.out.println(now);
		
		System.out.println(now.getYear());
		
		long time = now.getTime() + 1000 * 24 * 60 * 60;
		
		now.setTime(time);
		
		System.out.println(now);
	
	}

}
