package code038_countAndSAy;

public class Main {
	public static String countAndSay(int n) {
		String rs = "1";
		for (int i = 1; i < n; i++) {
			// 每次都需要将上次的结果最为下一次计算的输入
			rs = say(rs);
		}
		return rs;
	}

	private static String say(String input) {
		// 定义每个n对应的结果
		String out = "";
		// 算数
		int count = 0;
		// 字符定位
		char c = input.charAt(0);
		for (int i = 0; i < input.length(); i++) {
			// 计算相同字母累计次数
			if (c == input.charAt(i)) {
				count++;
			} else {
				// 遇到不同字母
				// 先拼接上个相同字符对应的结果
				out = out + count + c;
				// 要将count置为1，即使字符不重复，也有计数1
				count = 1;
				// 重新定位下一个字符
				c = input.charAt(i);
				// 【注意理解：递归使用上次的输出作为输入，直接拼接就可以；直接重新定位c即可，不需要substring】
			}
		}
		// 拼接最后相等／不想等字符的结果
		out = out + count + c;
		return out;
	}

	public static void main(String[] args) {
		countAndSay(5);
	}
}
