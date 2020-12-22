package day04;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		
		// 6. boolean remove(E e)
		c.add(new Point(1, 2));
		c.add(new Point(3, 4));
		c.add(new Point(5, 6));
		System.out.println(c);
		
		c.remove(new Point(1, 2));
		System.out.println(c);
		
		// 7. boolean addAll(Collection c)
		
		// 8. boolean containsAll(Collection c)
		
		// 9. boolean removeAll(Collection c)
	}

}
