package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/11.
 */
public class code037_ReverseInteger {
    public static int reverse(int x) {
        long rs = 0; int flag = 1, count = 0;
        if (x < 0){
            flag = -1;
            x = -x;
        }
        while (x > 0){
            rs += (x % 10) * Math.pow(10, count++);
            x = x / 10;
        }
        x = (int)rs; rs = 0;
        while (x > 0 && rs <= Integer.MAX_VALUE){
            rs += (x % 10) * Math.pow(10, --count);
            x = x / 10;
        }
        if (flag == -1){
            rs = -rs;
        }
        if (rs > Integer.MAX_VALUE || rs < Integer.MIN_VALUE)
            return 0;
        return (int) rs;
    }
    public static int reverse1(int x) {
        int rs = 0;
        while (x != 0 ){
            int pop = x % 10;
            x /= 10;
            if (rs > Integer.MAX_VALUE / 10 || rs == Integer.MAX_VALUE / 10 && pop > 7) return 0;
            if (rs < Integer.MIN_VALUE / 10 || rs == Integer.MIN_VALUE / 10 && pop < -8) return 0;
            rs = rs * 10 + pop;
        }
        return rs;
    }
    public static void main(String args[]){
        System.out.println(reverse1(-1563847412));
    }

}
