package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查看当前系统时间和16天5小时23分40秒以后的日期
 * 显示的格式：
 * 2016年05月25日 15：24：33
 * @author ZK
 *
 */
public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		System.out.println(sdf.format(date));
		
		long time = date.getTime();
		time += 1000 * 60 * 60 * 24 * 16;
		time += 1000 * 5 * 60 * 60;
		time += 1000 * 23 * 60;
		time += 1000 * 40;
		date.setTime(time);
		System.out.println(sdf.format(date));
		
		
	}

}
