package code20180101;

import java.util.Scanner;

/**
 * @author:zd
 * @date:2019年1月17日下午8:31:09
 * @parameter
 * @return
 */
public class One {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String aString = "";
		String bString = "";
		String rsString = "";
		String rs1String = "";
		while (a != 0) {
			aString += String.valueOf(a % 2);
			a /= 2;
		}
		while (b != 0) {
			bString += String.valueOf(b % 2);
			b /= 2;
		}
		for (int i = aString.length() - 1; i >= 0; i--) {
			int ab = aString.charAt(i) - '0';
			a += ab * Math.pow(2, aString.length() - 1 - i);
		}
		for (int i = bString.length() - 1; i >= 0; i--) {
			int ab = bString.charAt(i) - '0';
			b += ab * Math.pow(2, bString.length() - 1 - i);
		}
		int rs = a + b;
		while (rs != 0) {
			rsString += String.valueOf(rs % 2);
			rs /= 2;
		}
		System.out.println(Integer.parseInt(rsString));
	}
}
