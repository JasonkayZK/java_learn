package day04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDemo {

	public static void main(String[] args) {
/*
		int hour = 0;
		int min = 0;
		int sec = 0;
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sec++;
			if (sec == 60) {
				sec = 0;
				min++;
			}
			if (min == 60) {
				hour++;
			}
			if (hour == 24) {
				hour = 0;
			}
			System.out.println(hour + ":" + min + ":" + sec);
		}
*/
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		while (true) {
			System.out.println(sdf.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}










