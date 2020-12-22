package day05;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		
		// 1. boolean offer(E e)
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println(queue);
		
		// 2. E poll()
		String str = queue.poll();
		System.out.println(str);
		System.out.println(queue);
		
		// 3. E peek()
		str = queue.peek();
		System.out.println(str);
		System.out.println(queue);
		
		// 4. for iteration
		for (int i = queue.size(); i > 0; --i) {
			System.out.println(queue.poll());
		}
		System.out.println(queue);
				
		// 4'. while iteration
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
		System.out.println(queue);
		
		
		
	}

}



