package day03;

import java.util.Date;

public class DateDemo {
/**
 * java.util.Date
 * Date �е�ÿһ��ʵ��������ʾһ��ȷ�е�ʱ��㣻
 * �ڲ�ά����һ��long�� ��ʾ�ԣ�
 * 1970/01/01 - now�ĺ�����
 * �������ȱ��
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
