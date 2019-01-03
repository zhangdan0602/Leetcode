package Common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//linked按照存入方式存储；hash和tree按照排序存储
public class CollectionCommonMethod {
	public static void main(String[] args) {
		//ListMethod();
		MapMethod();
		 //SetMethod();
	}

	public static void ListMethod() {
		// list查找效率高、插入和删除低
		//按照存入顺序存储
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(1);
		//升序
		Collections.sort(list);
		//逆序
		Collections.sort(list,Collections.reverseOrder());
		for (int i : list) {
			System.out.println(i);
		}

		System.out.println(list.size());
		System.out.println(list.get(0));
		System.out.println(list.toArray());
		System.out.println(list.contains(1));
		System.out.println(list.indexOf(1));
		System.out.println(list.lastIndexOf(1));

		// LinkedList查找效率低
		//按照存入顺序存储
		List<Integer> list2 = new LinkedList<>();
		System.out.println(list2.addAll(list));
		Collections.sort(list);
		for (int i : list2) {
			System.out.println(i);
		}
		//删除索引对应的值
		System.out.println(list2.remove(1));
		System.out.println("rs="+list2.removeAll(list2));
		for (int i : list2) {
			System.out.println("i="+i);
		}
		list2.add(2);
		list2.set(0, 3);
		//list2.clear();
		for (int i : list2) {
			System.out.println(i);
		}
	}

	public static void SetMethod() {
		// 按照排序方式存储
		Set<Integer> set = new HashSet<>();
		set.add(5);
		set.add(4);
		for (int i:set) {
			System.out.println(i);
		}
		
		// 按照存入方式存储
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(3);
		set1.add(1);
		System.out.println(set1.addAll(set));
		//System.out.println(set1.remove(3));
		//System.out.println(set1.removeAll(set1));
		//set1.clear();
		System.out.println(set1.size());
		System.out.println(set1.contains(4));
		System.out.println(set1.retainAll(set));
		for (int i:set1) {
			System.out.println("i="+i);
		}
		
		
		
		// TreeSet实现排序 按照排序方式存储
		Set<Integer> set2 = new TreeSet<>();
		set2.add(3);
		set2.add(1);
		for (int i:set2) {
			System.out.println(i);
		}
	}

	public static void MapMethod() {
		//按照排序方式存储元素
		Map<Integer, Integer> map = new HashMap<>();
		map.put(2, 3);
		map.put(1, 2);

		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue(2));
		System.out.println(map.size());
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		// 普通遍历
		for (int i : map.keySet()) {
			System.out.println("[key=" + i + ";value=" + map.get(i) + "];");
		}
		// 数据量大时
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("[key=" + entry.getKey() + ";value=" + entry.getValue() + "];");
		}
		

		//按照存入方式存储元素
		Map<Integer, Integer> map1 = new LinkedHashMap<>();
		map1.put(4, 3);
		map1.put(3, 2);
		
		map1.putAll(map);
		//map1.remove(4);
		//map1.clear();
		System.out.println(map1.get(3));
		// 数据量大时
		for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
			System.out.println("[ key=" + entry.getKey() + ";value=" + entry.getValue() + " ];");
		}
		
		
		//按照排序方式存储元素
		Map<Integer, Integer> map2 = new TreeMap<>();
		map2.put(2, 3);
		map2.put(1, 2);
		// 数据量大时
		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			System.out.println("[key=" + entry.getKey() + ";value=" + entry.getValue() + "];");
		}
	}

}
