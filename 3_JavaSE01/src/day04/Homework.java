package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Homework {

	public static void main(String[] args) {
		// 1.
		Collection c1 = new ArrayList();
		c1.add("one");
		c1.add("two");
		c1.add("three");
		Collection c2 = new ArrayList();
		c2.add("four");
		c2.add("five");
		c2.add("six");
		c1.addAll(c2);
		System.out.println(c1); // one, ..., six
		
		Collection c3 = new ArrayList();
		c3.add("one");
		c3.add("five");
		System.out.println(c1.containsAll(c3)); // true
		
		c1.remove("two");
		System.out.println(c1); // one, three, four, ..., six
		
		// 2.
		Collection<String> c = new ArrayList<String> ();
		c.add("1");
		c.add("$");
		c.add("2");
		c.add("$");
		c.add("3");
		c.add("$");
		c.add("4");
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			if ("$".equals(it.next())) {
				it.remove();
			}
		}
		for (String s : c) {
			System.out.println(s); // 1, 2, 3, 4
		}
				
		// 3. 
		List<String> list = new ArrayList<String> ();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list.get(1)); // two
		list.set(2, "3");
		list.add(1, "2");
		list.remove(2);
		System.out.println(list); // one, 2, 3, four
		
		// 4.
		List<Integer> list4 = new ArrayList<Integer> ();
		for (int i = 0; i < 10; ++i) {
			list4.add(i);
		}
		System.out.println(list4); // 0,1,2,3,4,....,9
		List<Integer> subList = list4.subList(3, 7);
		System.out.println(subList); // 3,4,5,6
		for (int i = 0; i < subList.size(); ++i) {
			subList.set(i, subList.get(i) * 10);
		}
		System.out.println(list4); // 0,1,2,30,40,50,60,7,8,9
		
		list4.subList(7, 10).clear();
		System.out.println(list4); // 0,1,2,30,40,...,60
		
		// 5.
		List<Integer> list5 = new ArrayList<Integer> ();
		for (int i = 0; i < 10; ++i) {
			list5.add(i);
		}
		Integer[] arr5 = list5.toArray(new Integer[list5.size()]);
		for (int i : arr5) {
			System.out.println(i);
		}
		
		
		// 6. 
		String[] arr6 = {"one", "two", "three"};
		List<String> list6 = Arrays.asList(arr6);
		System.out.println(list6);
		
		// 7.
		List<Integer> list7 = new ArrayList<Integer> ();
		Random rand = new Random();
		for (int i = 0; i < 10; ++i) { 
			list7.add(rand.nextInt(100));
		}
		System.out.println(list7);
		Collections.sort(list7);
		System.out.println(list7);
	}

}












