package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionSortDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer> ();
		Random rand = new Random();
		for (int i = 0; i < 10; ++i) {
			list.add(rand.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

}
