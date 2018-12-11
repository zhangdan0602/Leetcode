package PalindromeNumber;

public class Main {
	public static boolean isPalindrome(int x) {
		if (x<0) {
			return false;
		}
		int number=x;
		int rs=0,num=0;
		while (x!=0) {
			num=x%10;
			x=x/10;
			if (rs>Integer.MAX_VALUE/10||rs==Integer.MAX_VALUE/10&&num>7) {
				return false;
			}
			rs=rs*10+num;
		}
		System.out.println(rs);
		System.out.println(number);
		if (rs==number) {
			return true;
		}
		return false;
		
		
	}

	public static void main(String[] args) {
		isPalindrome(10);
	}
}
