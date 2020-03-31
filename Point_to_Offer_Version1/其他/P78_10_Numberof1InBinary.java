package Point_to_Offer_Version1.其他;

public class P78_10_Numberof1InBinary
{
    /*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。*/
    // 超时
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if ((n&1) == 1){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int hammingWeight1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if ((n&flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(hammingWeight1(9));
        System.out.println(hammingWeight2(9));
    }
}
