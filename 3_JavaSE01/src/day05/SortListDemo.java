package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListDemo {

	public static void main(String[] args) {
		// 1. Interface Comparable
		List<Point> list = new ArrayList<Point> ();
		list.add(new Point(1, 2));
		list.add(new Point(1, 3));
		list.add(new Point(4, 2));
		list.add(new Point(2, 4));
		list.add(new Point(3, 3));
		list.add(new Point(9 ,2));
		list.add(new Point(8, 3));
		list.add(new Point(1, 1));
		System.out.println();

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);

		
	}

}
