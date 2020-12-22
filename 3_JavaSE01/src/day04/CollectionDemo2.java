package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo2 {

	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String> ();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		System.out.println(c);
		
		// for each
		for (String str : c) {
			System.out.println(str);
		}
		
		// Iterator
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		
		
	}

}
