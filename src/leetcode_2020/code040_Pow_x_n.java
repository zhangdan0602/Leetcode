package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/11.
 */
public class code040_Pow_x_n {
    public static double myPow(double x, int n) {
        int flag = 1;
        if (n < 0){
            flag = -1;
            n = -n;
        }
        double rs = 1;
        while (n > 0){
            rs = rs * x;
            n--;
        }
        if (flag == -1)
            return 1 / rs;
        return rs;
    }
    public static double fastPow(double x, long n){
        if (n == 0)
            return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }
    public static double myPow1(double x, int n){
        long N = n;
        if (n < 0){
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }
    public static void main(String args[]){
        System.out.println(myPow1(2.0000, -2));
    }
}
