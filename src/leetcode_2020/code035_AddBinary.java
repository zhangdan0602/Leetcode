package leetcode_2020;

/**
 * Created by Zd on 2020/2/11.
 */
public class code035_AddBinary {
    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j>= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int sum = (x + y + carry) % 2;
            stringBuilder.append(sum);
            carry = (x + y + carry) / 2;
        }
        return stringBuilder.reverse().toString();
    }
    public static String addBinary1(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = a.length(), n = b.length();
        if (m < n)
            return addBinary1(b, a);
        int len = Math.max(m, n);
        int carry = 0, j = n - 1;
        for (int i = len - 1; i >= 0 ; i--) {
            if (a.charAt(i) == '1')
                carry++;
            if (j > -1 && b.charAt(j--) == '1')
                carry++;
            if (carry % 2 == 1)
                stringBuilder.append("1");
            else
                stringBuilder.append("0");
            carry = carry / 2;
        }
        if (carry == 1)
            stringBuilder.append("1");
        return stringBuilder.reverse().toString();
    }
    public static void main(String args[]){
        System.out.println(addBinary("11", "1"));
    }
}
