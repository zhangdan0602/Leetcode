package code013_RoamtoInteger;

public class Main {
	public static int romanToInt(String s) {
		// 可以通过两个数组，一一对应就可以
		int[] vals = { 1000, 500, 100, 50, 10, 5, 1 };
		char[] romans = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int num = 0;
		//定义两个变量，一个用来遍历数组，一个用来遍历罗马字符串
		for (int i = 0, j = 0; i < romans.length; i++) {
			//字符指针需要考虑到字符串长度-2【否则溢出】； 判断罗马字符是否与数组中字符匹配
			while (j < s.length() - 1 && (s.charAt(j) == romans[i])) {
				//判断罗马字符是否为特殊情况 C
				if (s.charAt(j) == 'C') {
					if (s.charAt(j + 1) == 'M') {
						num += 900;
						//罗马字符指针后移两位
						j += 2;
					} else if (s.charAt(j + 1) == 'D') {
						num += 400;
						j += 2;
					} else {
						//整数加上数组中值就可以
						num += vals[i];
						//罗马字符指针后移一位
						j += 1;
					}
				} else if (s.charAt(j) == 'X') {
					if (s.charAt(j + 1) == 'C') {
						num += 90;
						j += 2;
					} else if (s.charAt(j + 1) == 'L') {
						num += 40;
						j += 2;
					} else {
						num += vals[i];
						j += 1;
					}
				} else if (s.charAt(j) == 'I') {
					if (s.charAt(j + 1) == 'V') {
						num += 4;
						j += 2;
					} else if (s.charAt(j + 1) == 'X') {
						num += 9;
						j += 2;
					} else {
						num += vals[i];
						j += 1;
					}
				} else {
					//判断罗马字符不是特殊情况 直接加数组中的值，字符指针后移一位
					num += vals[i];
					j += 1;
				}
			}
			//字符指针在字符串最后一位时
			while ((j == s.length() - 1) && (s.charAt(j) == romans[i])) {
				num += vals[i];
				j += 1;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		romanToInt("MCMXCIV");
	}
}
