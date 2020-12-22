package day03;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import day02.Point;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		// 1. boolean Add(E e)
		c.add("one");
		c.add(1);
		c.add(2.2);
		c.add(Calendar.getInstance());
		
		System.out.println(c);
	
		// 2. int Size()
		
		// 3. boolean isEmpty()
		
		// 4. void clear()
		
		// 5. boolean contains(E e)
		System.out.println(c.contains(new String("one")));
		
		// 6. Collection stores the address
		c.clear();
		Point p = new Point(1, 2);
		c.add(p);
		System.out.println(c);
		
		p.setX(2);
		System.out.println(c);
		
		
	}

}
