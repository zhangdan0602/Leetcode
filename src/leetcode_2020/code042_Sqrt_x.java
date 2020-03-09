package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/11.
 */
public class code042_Sqrt_x {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        long num;
        int pivot = 0, left = 2, right = x / 2;
        while (left <= right){
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if(num < x) left = pivot + 1;
            else
                return pivot;
        }
        return right;
    }
    public int mySqrt1(int x) {
        if (x < 2)
            return x;
        int left = mySqrt1(x >> 2) << 1;
        int right = left + 1;
        return (long)right * right > x ? left : right;
    }
}
