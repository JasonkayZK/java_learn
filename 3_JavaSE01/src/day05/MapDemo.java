package day05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// 1. V put(K k, V v)
		Integer chinese = map.put("Chinese", 98);
		map.put("English", 94);
		map.put("History", 88);
		map.put("Math", 66);
		System.out.println(chinese);
		System.out.println(map);
		
		// 1'. replace
		Integer old = map.put("Chinese", 68);
		System.out.println(map);
		System.out.println("Old: " + old);
		
		// 2. V get(K k)
		Integer value = map.get("Math");
		System.out.println(value);
		value = map.get("Physics");
		System.out.println(value);
		
		// 3. V remove(V v)
		value = map.remove("Math");
		System.out.println(map);
		System.out.println(value);
		
		// 4. Traverse Map
		map.clear();
		map.put("Chinese", 98);
		map.put("English", 94);
		map.put("History", 88);
		map.put("Math", 66);
		// 4.1 Iterate Key: Set<K> keySet();
		for (String k : map.keySet()) {
			System.out.println(k);
		}
		
		// 4.2 Iterate K-V
		// Set<Entry> entrySet();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		// 4.3 Iterate V: Collection values()
		Collection<Integer> c = map.values();
		for (Integer v : c) {
			System.out.println(v);
		}		
		
	}

}
















