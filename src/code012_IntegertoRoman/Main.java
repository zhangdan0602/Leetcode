package code012_IntegertoRoman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;

public class Main {
	public static String intToRoman(int num) {
		// 需要LinkedHashMap linkedMap在于存储数据你想保持进入的顺序与被取出的顺序一致的话，优先考虑LinkedMap
		Map<Integer, String> map3 = new LinkedHashMap<>();
		map3.put(1000, "M");
		map3.put(900, "CM");
		map3.put(500, "D");
		map3.put(400, "CD");
		map3.put(100, "C");
		map3.put(90, "XC");
		map3.put(50, "L");
		map3.put(40, "XL");
		map3.put(10, "X");
		map3.put(9, "IX");
		map3.put(5, "V");
		map3.put(4, "IV");
		map3.put(1, "I");
		
		String rsString = "";
		// 遍历map
		for (Map.Entry<Integer, String> entry : map3.entrySet()) {
			while (num >= entry.getKey()) {
				//拼接字符
				rsString = rsString + entry.getValue();
				//更新值
				num -= entry.getKey();
			}
		}
		return rsString;
		
		/*
		// 对key排序，最好用TreeMap
		Map<Integer, String> map = new TreeMap<>();
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		
	
		// 得将map转为list排序
		List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());
		// map中key默认是升序，需要通过new Comparator进行逆序排序
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				// 2-1
				return o2.getKey() - o1.getKey();
			}
		});
		// 需要LinkedHashMap linkedMap在于存储数据你想保持进入的顺序与被取出的顺序一致的话，优先考虑LinkedMap
		Map<Integer, String> map2 = new LinkedHashMap<>();
		for (int i = 0; i < list.size(); i++) {
			// 将list内容存map
			Map.Entry<Integer, String> entry = list.get(i);
			map2.put(entry.getKey(), entry.getValue());

		}
		String rsString = "";
		// 遍历map
		for (Map.Entry<Integer, String> entry : map2.entrySet()) {
			while (num >= entry.getKey()) {
				//拼接字符
				rsString = rsString + entry.getValue();
				//更新值
				num -= entry.getKey();
			}
		}
		return rsString;
		 */
		
	
		
		 /*
		String rs = "";
		//可以通过两个数组，一一对应就可以
		int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		for (int i = 0; i < vals.length; i++) {
			while (num >= vals[i]) {
				rs = rs + romans[i];
				num -= vals[i];
			}
		}
		return rs;
		*/

	}

	public static void main(String[] args) {
		intToRoman(86);
	}
}
