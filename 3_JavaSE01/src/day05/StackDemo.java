package day05;

import java.util.Deque;
import java.util.LinkedList;

public class StackDemo {

	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<String> ();
		
		// 1. void push(E e)
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		System.out.println(stack);
		
		// 2. E pop();
		
		// 3. E peek();
		
		// 4. for Iteration
		
		// 4'. while Iteration
	}

}
