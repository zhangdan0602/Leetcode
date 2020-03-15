package Point_to_Offer_Version1.递归;

public class P73_09_Fibonacci
{
    /*
    现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。假设n<=39。
    斐波那契数列：0,1,1,2,3,5,8........ 总结起来就是：第一项是0，第二项是1，后续第n项为第n-1项和第n-2项之和。
    */
    public int fib(int n) {
        if (n < 2)
            return n;
        int one = 1;
        int two = 0;
        int sum = 0;
        for (int i = 0; i < n ; i++)
        {
            sum = (one + two) % 1000000007;
            two = one;
            one = sum;
        }
        return two;
    }
    /*
    0   1   1   2   3
    two+one=sum
        ||  ||
        two+one=sum
            two+one=sum
    */
}
