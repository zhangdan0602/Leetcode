package leetcode_2019.code022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static List<String> generateParenthesis(int n) {
		List<String> rs = new ArrayList<>();
		// 回溯法
		backtrack(rs, "", 0, 0, n);
		return rs;
	}

	private static void backtrack(List<String> rs, String current, int open, int close, int n) {
		// 一个字符串长度=对数*2
		if (current.length() == n * 2) {
			// 添加一个字符串
			rs.add(current);
			return;
		}
		// 左括号小于对数时，字符串拼接左括号，而且左括号个数+1
		if (open < n) {
			backtrack(rs, current + "(", open + 1, close, n);
		}
		//右括号个数小于左括号个数时，字符串拼接右括号，而且右括号个数+1
		if (close < open) {
			backtrack(rs, current + ")", open, close + 1, n);
		}
	}

	public static void main(String[] args) {
		generateParenthesis(3);
	}
}
