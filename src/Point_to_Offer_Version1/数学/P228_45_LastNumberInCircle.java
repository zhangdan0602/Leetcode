package Point_to_Offer_Version1.数学;

public class P228_45_LastNumberInCircle
{
    /*
    * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    */
    // 迭代
    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++)
        {
            last = (last + m) % i;
        }
        return last;
    }

    // 递归
    public int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        if (n == 1)
            return 0;
        return (lastRemaining1(n - 1, m) + m) % n;
    }
    public static void main(String[] args){
        P228_45_LastNumberInCircle lastNumberInCircle = new P228_45_LastNumberInCircle();
        System.out.println(lastNumberInCircle.lastRemaining1(5, 3));
    }
}
