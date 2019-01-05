package code050_Pow;

/**
 * @author:zd
 * @date:2019年1月4日下午5:18:29
 * @parameter
 * @return
 */
public class Main {
	public double myPow(double x, int n) {
		return Math.pow(x, n);
	}

	public static double myPow1(double x, int n) {
		// 0次幂时，直接return 1
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			// 幂小于0时，转为1/x，而且在幂运算时幂为正数，当n的min为Inreger.MIN_VALUE时，需要+1，这样取反时正数才为Inreger.MAX_VALUE
			return 1 / x * myPow1(1 / x, -(n + 1));
		} else {
			// 幂大于0时，使用二分法
			double f = myPow1(x, n / 2);
			// 幂为偶数时
			if (n % 2 == 0) {
				// 返回二分的两次积
				return f * f;
			} else {
				// 幂为奇数时，需要再乘一个x
				return x * f * f;
			}
		}
	}

	public static void main(String[] args) {
		myPow1(2, 1);
	}
}
