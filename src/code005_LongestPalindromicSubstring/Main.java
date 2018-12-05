package code005_LongestPalindromicSubstring;

public class Main {
	public static String longestPalindrome(String s) {
		if (s.length() < 1 || s == null) {
			return "";
		}
		int start = 0, end = 0;
		//考虑：str的每一字符 从头开始
		for (int i = 0; i < s.length(); i++) {
			//考虑：str长度为奇数
			int len1 = expandAroundCenter(s, i, i);
			//考虑：str长度为偶数
			int len2 = expandAroundCenter(s, i, i + 1);
			//获取这一字母为中心的回文串的最长长度
			int len = Math.max(len1, len2);
			if (len > end - start) {
				//获取最长回文串的起始下标 
				start = i - (len - 1) / 2;
				//获取最长回文串的终止下标 
				end = i + len / 2;
			}
		}//substring是左闭右开，所以需要end+1 
		return s.substring(start, end+1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		//奇数时以这一字符为中心，偶数时以这一字符和下一字符为中心，不断向左向右遍历
		while (right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		//返回长度时需要-1，否则溢出
		return right - left - 1;
	}

	public static void main(String[] args) {

	}
}
