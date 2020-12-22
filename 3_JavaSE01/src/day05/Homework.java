package day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Homework {

	public static void main(String[] args) {
		// 1. 2.
		List<Person> c = new ArrayList<Person> ();
		c.add(new Person("zk", 9, 100));
		c.add(new Person("zk", 22, 10040));
		c.add(new Person("zk", 43, 10043250));
		c.add(new Person("zk", 12, 10032450));
		c.add(new Person("zk", 51, 10134500));
		c.add(new Person("zk", 3, 5432000));
		System.out.println(c);
		Collections.sort(c);
		System.out.println(c);
		
		// 3.
		Collections.sort(c, new Comparator<Person> () {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getSalary() - o2.getSalary();
			}
		});
		System.out.println(c);
		
		// 4. 
		Queue<Integer> q = new LinkedList<Integer> ();
		for (int i = 1; i <= 5; ++i) {
			q.offer(i);
		}
		// For iteration
//		for (int i = q.size(); i > 0; --i) {
//			System.out.println(q.poll());
//		}
		// While iteration
		while (q.size() > 0) {
			System.out.println(q.poll());
		}
		
		// 5.
		Deque<Integer> stack = new LinkedList<Integer> ();
		for (int i = 1; i <= 5; ++i) {
			stack.push(i);
		}
		// For iteration
//		for (int i = stack.size(); i > 0; --i) {
//			System.out.println(stack.pop());
//		}
		// While iteration
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	
		// 6.
		Map<String, Integer> map = new HashMap<String, Integer> ();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		System.out.println(map.get("物理"));
		
		map.put("化学", 96);
		System.out.println(map);
		
		map.remove("英语");
		System.out.println(map);
		
		// key
		Set<String> key = map.keySet();
		for (String k : key) {
			System.out.println(k);
		}
		
		// Entry
		Set<Entry<String, Integer>> entry = map.entrySet();
		for (Entry<String, Integer> e : entry) {
			System.out.println("Key: " + e.getKey() + ", Value: " + e.getValue());
		}
		
		// Value
		Collection<Integer> collec = map.values();
		for (Integer co : collec) {
			System.out.println(co);
		}
	}
	
}

class Person implements Comparable<Person> {
	private int age;
	private String name;
	private int salary;
	
	public Person(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return "name: " + this.name + ", age: " + this.age + ", salary: " + this.salary;
	}

	@Override
	public int compareTo(Person p) {
		return this.age - p.getAge();
	}
	
}
