package code008_StringtoInteger;

public class Main {
	public static int myAtoi(String str) {
		if (str == null) {
			return 0;
		}
		int it = 0;
		long rs = 0;
		int flag = 1;
		while (it < str.length() && str.charAt(it) == ' ') {
			it++;
		}
		if (it == str.length()) {
			return 0;
		}
		if (str.charAt(it) == '+' || str.charAt(it) == '-'){
			flag = str.charAt(it) == '+' ? 1 : -1;
			it++;
			}
		while (it < str.length()&&(str.charAt(it) >= '0' && str.charAt(it) <= '9')  ) {
			
				rs = rs * 10 + (str.charAt(it++) - '0');
				
				if (rs > Integer.MAX_VALUE) {
					return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
			
		}
		System.out.println(flag * rs);
		return (int) (flag * rs);
	}

	public static void main(String[] args) {
		myAtoi("   -42");
	}
}
