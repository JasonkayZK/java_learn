package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String> ();
		list.add("����ʦ12345");
		list.add("����ʦ1234");
		list.add("����ʦ12");
		list.add("����ʦ1");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		// Comparator
		
		// 1.
//		MyComparator comp = new MyComparator();
		
		// 2.
//		Comparator<String> com1 = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			}
//		};
//		Collections.sort(list, com1);
		
		// 3.
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		
		});
		System.out.println(list);
	}

}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return -(o1.length() - o2.length());
	}
	
}


