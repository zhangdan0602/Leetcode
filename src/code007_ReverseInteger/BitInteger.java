package code007_ReverseInteger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class BitInteger {
	public static int reverse(int x) {
		// 存入链表
				List<Integer> num = new ArrayList<>();
				while (x != 0) {
					num.add(x % 10);
					x = x / 10;
				}
				x=0;
				BigInteger number=new BigInteger(String.valueOf(x));
				for (int i = num.size(),j=0; i >0; i--) {
					BigInteger l=new BigInteger(String.valueOf(num.get(i-1)));		
					int m=(int) Math.pow(10, j++);
					BigInteger n=new BigInteger(String.valueOf(m));		
					BigInteger mul=l.multiply(n);
					number=number.add(mul);
					//System.out.println("l="+l+";n="+n+";mul="+mul+";rs="+number);
				}
				BigInteger max=new BigInteger(String.valueOf(2147483647));
				if (number.compareTo(max)==1) {
					x=0;
					return x;
				}
				x=Integer.parseInt(number.toString());
				return x;
	}


	public static void main(String[] args) {
		reverse(1563847412);
	}
}
