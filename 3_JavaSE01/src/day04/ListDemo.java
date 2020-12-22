package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String> ();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		// 1. E set(int index, E e)
		String old = list.set(1, "2");
		System.out.println(old);
		
		// 2. E get(int index)
		String str = list.get(2);
		System.out.println(str);
		
		// 3. for
		for (int i = 0; i < list.size(); ++i) {
			str = list.get(i);
			System.out.println(list.get(i));
		}
		
		// 4. void add(int index, E e)
		list.add(2, "two");
		System.out.println(list);
		
		// 5. E remove(int index)
		old = list.remove(1);
		System.out.println(list);
		System.out.println("old: " + old);
		
		// 6. List subList(int start, int end)
		List<Integer> list2 = new ArrayList<Integer> ();
		for (int i = 0; i < 10; ++i) {
			list2.add(i);
		}
		System.out.println(list2);
		
		List<Integer> subList = list2.subList(3, 8);
		System.out.println(subList);
		for (int i = 0; i < subList.size(); ++i) {
			subList.set(i, subList.get(i) * 10);
		}
		System.out.println(subList);
		System.out.println(list2);
		
		// 6'. clear
		list2.subList(2, 9).clear();
		System.out.println(list2);
		
		// 7. T[] toArray(new T[] arr)
		String[] arr = list.toArray(new String[10]);
		System.out.println(arr.length);
		for (String s : arr) {
			System.out.println(s);
		}
		
		// 8. Arrays.asList()
		String[] array = {"one", "two", "three", "four"};
		List<String> arrList = Arrays.asList(array);
		System.out.println(arrList);
		//arrList.add("five");
		//System.out.println(arrList);
		
		arrList.set(1, "2");
		for (String s : array) {
			System.out.println(s);
		}
		
		// 8'. addAll
//		List<String> arrList2 = new ArrayList<String> ();
//		arrList2.addAll(arrList);
		List<String> arrList2 = new ArrayList<String> (arrList);
		arrList2.add("five");
		System.out.println(arrList);
		System.out.println(arrList2);
				
		
	}

}
