package leetcode_2020;

/**
 * Created by Zd on 2020/2/11.
 */
public class code039_DivideTwoIntegers {
    public static long opposite(long x){
        return ~x + 1;
    }
    public static long divide(long dividend, long divisor){
        long rs = 1, flag = 1;
        if (dividend < 0){
            flag = opposite(flag);
            dividend = opposite(dividend);
        }
        if (divisor < 0 ){
            flag = opposite(flag);
            divisor = opposite(divisor);
        }
        long original_dividend = dividend, original_divisor = divisor;
        if (dividend < divisor)
            return 0;
        dividend -= divisor;
        while (divisor <= dividend){
            rs += rs;
            divisor += divisor;
            dividend -= divisor;
        }
        long r = rs + divide(original_dividend - divisor, original_divisor);
        return flag > 0 ? r : opposite(r);
    }
    public static int divide(int dividend, int divisor) {
        long rs = divide((long)dividend, (long) divisor);
        long m = 2147483648L;
        if (rs == m)
            return Integer.MAX_VALUE;
        else
            return (int) rs;
    }
    public static void main(String args[]){
        System.out.println(divide(7, -3));
    }
}
