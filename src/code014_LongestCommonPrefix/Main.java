package code014_LongestCommonPrefix;

public class Main {
	public static String longestCommonPrefix(String[] strs) {
		//字符串为空
		if (strs == null || strs.length == 0)
			return "";
		//字符串长度只有1，返回这个字符串就可以为空
		if (strs.length == 1) {
			return strs[0];
		}
		
		
		int minLength = strs[0].length();
		for (int i = 0; i < strs.length; i++) {
			//获得最短字符串长度就可以
			minLength = Math.min(minLength, strs[i].length());
		}
		//如果字符串数组中有一个字符串为空，则整体返回空
		if (minLength == 0) {
			return "";
		}
		String rString = "";
		//公共前缀的最长长度为最短字符串长度
		for (int i = 0; i < minLength; i++) {
			//遍历字符串数组
			for (int j = 1; j < strs.length; j++) {
				//只需要判断后面 每一个与第一个是否相同就可以，不需要前一个与后一个两两相比
				//不相等就返回
				if (strs[0].charAt(i)!=strs[j].charAt(i))
					return rString;
			}
			//相等就拼接上
			rString += strs[0].charAt(i);
		}
		return rString;
	}

	public static void main(String[] args) {
		String strs[] = new String[] { "aa", "a"};
		longestCommonPrefix(strs);
	}
}
