package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/11.
 */
public class code038_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        int rs = 0, pre = x;
        if (pre == 0)
            return true;
        if (pre < 0 || pre % 10 == 0 && pre != 0)
            return false;
        while (x != 0){
            int pop = x % 10;
            x /= 10;
            if (rs > Integer.MAX_VALUE / 10 || rs == Integer.MAX_VALUE / 10 && pop > 7) return false;
            rs = rs * 10 + pop;
        }
        if (rs != pre)
            return false;
        return true;
    }
    public static boolean isPalindrome1(int x) {
        int rs = 0, pre = x;
        StringBuilder reverseOrder = new StringBuilder();
        if (pre == 0)
            return true;
        if (pre < 0 || pre % 10 == 0 && pre != 0)
            return false;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            reverseOrder.append(String.valueOf(pop));
        }
        if (Long.valueOf(reverseOrder.toString()) != pre)
            return false;
        return true;
    }
    public static boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;
        int reverseNumber = 0;
        while (x > reverseNumber){
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }
    public static void main(String args[]){
        System.out.println(isPalindrome(-12));
    }
}
