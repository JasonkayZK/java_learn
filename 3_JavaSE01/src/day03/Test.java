package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �鿴��ǰϵͳʱ���16��5Сʱ23��40���Ժ������
 * ��ʾ�ĸ�ʽ��
 * 2016��05��25�� 15��24��33
 * @author ZK
 *
 */
public class Test {

	public static void main(String[] args) {
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
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
