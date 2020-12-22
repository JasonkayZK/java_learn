package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SycnListAndMapDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		
		// 1. LinkedList / ArrayList unsecured!!!!
		list = Collections.synchronizedList(list);
		System.out.println(list);
		
		// 2. HashSet unsecured!
		Set<String> set = new HashSet<String> (list);
		System.out.println(set);
		set = Collections.synchronizedSet(set);
		System.out.println(set);
		
		// 3. HashMap unsecured!
		Map<String, Integer> map = new HashMap<String, Integer> ();
		map.put("Chinese", 94);
		map.put("Math", 33);
		map.put("English", 23);
		System.out.println(map);
		
		map = Collections.synchronizedMap(map);
		System.out.println(map);
		
	}

}
