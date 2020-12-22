package day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IterationDemo {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		
		// 1. Iterator
		// boolean hasNext();
		// Object next();
		Iterator it = c.iterator();
		while (it.hasNext()) {
			String str = (String)it.next();
			System.out.println(str);
		}
		
		// 2. for each
		for (Object o : c) {
			String str = (String)o;
			System.out.println(str);
		}
		
		// 3. 
		
		
	}

}
