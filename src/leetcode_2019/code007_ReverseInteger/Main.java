package leetcode_2019.code007_ReverseInteger;

public class Main {
	public static int reverse(int x) {
		int rs=0;
		while (x != 0) {
			//从个位依次得到数值
			int num=x % 10;
			x = x / 10;
			//从左到右运算符 
			if (rs>Integer.MAX_VALUE/10||(rs==Integer.MAX_VALUE/10&&num>7)) {
				return 0;
			}
			if (rs<Integer.MIN_VALUE/10||(rs==Integer.MIN_VALUE/10&&num<-8)) {
				return 0;
			}
			//这样求和更为简单 【相比于原数逆序输入到集合，集合从最后再求和】
			//边获取原数的个位数，边求和【而不是全部逆序后，边获取逆序数的个位数，边求和】
			rs=rs*10+num;
		}
		return rs;
	}
	public static void main(String[] args) {
		reverse(1463847412);
	}
}
