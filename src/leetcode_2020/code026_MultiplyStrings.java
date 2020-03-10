package leetcode_2020;

/**
 * Created by Zd on 2020/2/10.
 */
public class code026_MultiplyStrings {
    public static String add(String num1, String num2){
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int x2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x1 + x2 + carry) % 10;
            stringBuilder.append(sum);
            carry = (x1 + x2 + carry) / 10;
        }
        return stringBuilder.reverse().toString();
    }
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String rs = "0";
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            int carry = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                stringBuilder.append('0');
            }
            int n2 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                stringBuilder.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            rs = add(rs, stringBuilder.reverse().toString());
        }
        return rs;
    }
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int res[] = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            int x1 = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0 ; j--) {
                int x2 = num1.charAt(j) - '0';
                int sum = res[i + j + 1] + x1 * x2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0)
                continue;
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }
    public static void main(String args[]){
        System.out.println(multiply1("123", "456"));
    }
}
