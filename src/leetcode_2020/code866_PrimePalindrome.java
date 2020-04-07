package leetcode_2020;

//https://leetcode-cn.com/problems/prime-palindrome/
/*
*
* 求出大于或等于 N 的最小回文素数。

回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。

例如，2，3，5，7，11 以及 13 是素数。

回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。

例如，12321 是回文数。

*/
public class code866_PrimePalindrome
{
    public int primePalindrome(int N)
    {
        if (N == 1)
            return 2;
        int res;
        while (true)
        {
            String s = String.valueOf(N);
            //所有的回文素数都是奇数位的。偶数位的回文数不是素数。
            //新增了一个判断，用于跳过数字长度为偶数的区间
            if (s.length() > 2 && (s.length() & 1) == 0)
            {
                N = (int) Math.pow(10, s.length()) + 1;
                continue;
            }
            if (isPalindrom(N) && isPrime(N))
            {
                res = N;
                return res;
            }
            N++;
        }
    }

    private boolean isPrime(int N)
    {
        if (N < 2)
            return false;
        int r = (int) Math.sqrt(N);
        for (int i = 2; i <= r; i++)
        {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    private boolean isPalindrom(int n)
    {
        String s = String.valueOf(n);
        int start = 0, end = s.length() - 1;
        while (start <= end && start <= s.length() - 1 && end >= 0)
        {
            if (s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        code866_PrimePalindrome primePalindrome = new code866_PrimePalindrome();
        System.out.println(primePalindrome.primePalindrome(13));//12422//1215122// 9989900
    }
}
