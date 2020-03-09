package thss_programTest.code20180101;

import java.util.Scanner;


/**
 * @author:zd
 * @date:2019年1月9日上午11:14:58
 * @parameter
 * @return
 */
public class InverseAdd {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String a_2 = "";
		String b_2 = "";
		String rString = "";
		a_2 = tenToTwo(a, a_2);
		b_2 = tenToTwo(b, b_2);
		rString = addAB(a_2, b_2);
		int rs = twoToTen(rString);
		System.out.println(rs);
	}

	private static int twoToTen(String rString) {
		int rs = 0;
		for (int i = rString.length() - 1; i >= 0; i--) {
			rs += (rString.charAt(i) - '0') * Math.pow(2, rString.length() - 1 - i);
		}
		return rs;
	}

	private static String addAB(String a_2, String b_2) {
		String rString = "";
		int n1 = a_2.length();
		int n2 = b_2.length();
		int carry = 0;
		int i1 = n1 - 1;
		int i2 = n2 - 1;
		while (i1 >= 0 && i2 >= 0) {
			int sum = a_2.charAt(i1) - '0' + b_2.charAt(i2) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			rString += String.valueOf(sum);
			i1--;
			i2--;
		}
		if (i1 < 0 && i2 < 0) {
			if (carry == 1) {
				rString += String.valueOf('1');
			}
		}

		while (i1 >= 0) {
			int sum = a_2.charAt(i1) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			rString += String.valueOf(sum);
			i1--;
		}
		while (i2 >= 0) {
			int sum = b_2.charAt(i2) - '0' + carry;
			carry = sum / 2;
			sum = sum % 2;
			rString += String.valueOf(sum);
			i2--;
		}
		if (carry == 1) {
			rString += String.valueOf('1');
		}
		return rString;
	}

	private static String tenToTwo(int a, String a_2) {
		while (a != 0) {
			a_2 += String.valueOf(a % 2);
			a = a / 2;
		}
		return a_2;
	}
}
