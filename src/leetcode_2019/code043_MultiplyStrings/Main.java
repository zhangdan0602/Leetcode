package leetcode_2019.code043_MultiplyStrings;

/**
 * @author:zd
 * @date:2019年1月3日下午7:26:02
 * @parameter
 * @return
 */
public class Main {
	public static String multiply(String num1, String num2) {
		int n1 = num1.length() - 1;
		int n2 = num2.length() - 1;
		if (n1 < 0 || n2 < 0) {
			return "";
		}
		// 乘积的结果位数最多为：两个乘数的位数之和
		int mul[] = new int[n1 + n2 + 2];
		// 循环两个乘数的位数
		for (int i = n1; i >= 0; i--) {
			for (int j = n2; j >= 0; j--) {
				// 两个乘数的每一位进行相乘
				int midmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				// 相乘结果+进位
				midmul += mul[i + j + 1];
				// 第i位和第j位相乘的结果在乘积中的位置为[i+j,i+j+1]
				// [i+j]需要累加；相当于结果高位【数组中为低位】
				mul[i + j] += midmul / 10;
				// [i+j+1]直接加余数即可
				mul[i + j + 1] = midmul % 10;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		int i = 0;
		while (i < mul.length - 1 && mul[i] == 0)
			// 截取前面的0
			i++;
		for (; i < mul.length; i++) {
			// 拼接字符串作为结果
			sBuilder.append(mul[i]);
		}
		return sBuilder.toString();
	}

	public static void main(String[] args) {
		multiply("123", "456");
	}
}
