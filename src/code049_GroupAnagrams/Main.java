package code049_GroupAnagrams;

import java.util.*;

/**
 * @author:zd
 * @date:2019年1月4日下午4:47:08
 * @parameter
 * @return
 */
public class Main {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}
		// map的key用于区分不同的字符串
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			// 每一字符串转为字符数组
			char[] ch = s.toCharArray();
			// 排序字符数组【因为每一集合中字符串对应的字符是固定的】
			Arrays.sort(ch);
			// 字符数组转为字符串
			String key = String.valueOf(ch);
			// 查看map中是否有这一有序字符串
			if (!map.containsKey(key)) {
				// 没有，则创建新的list存放这一字符串相关的字符串
				map.put(key, new ArrayList<>());
			}
			// 有，则直接在这一字符串对应的key中加上s
			map.get(key).add(s);
		}
		// 最后返回map中的所有值
		return new ArrayList(map.values());
	}

	// 计数法
	public static List<List<String>> groupAnagrams1(String[] strs) {
		if (strs.length == 0) {
			return new ArrayList<>();
		}
		// map的key用于区分不同的字符串
		Map<String, List<String>> map = new HashMap<>();
		// 用于存储字符出现的次数
		int count[] = new int[26];
		for (String s : strs) {
			// 每次将计数数组置为0
			Arrays.fill(count, 0);
			for (char c : s.toCharArray()) {
				// 字符次数累加
				count[c - 'a']++;
			}
			StringBuilder sBuilder = new StringBuilder("");
			for (int i = 0; i < 26; i++) {
				// 这一字符串转为StringBuilder
				sBuilder.append("#");
				sBuilder.append(count[i]);
			}
			//StringBuilder转为字符串
			String key = sBuilder.toString();
			// 查看map中是否有这一字符串
			if (!map.containsKey(key)) {
				// 没有，则创建新的list存放这一字符串相关的字符串
				map.put(key, new ArrayList<>());
			}
			// 有，则直接在这一字符串对应的key中加上s
			map.get(key).add(s);
		}
		// 最后返回map中的所有值
		return new ArrayList(map.values());
	}

	public static void main(String[] args) {
//		groupAnagrams(new String[] { "", "", "" });
	}
}
