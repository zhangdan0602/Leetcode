package 算法分析与设计.动态规划;

public class ClimbStairs
{
    public int climbStairs(int n) {
        if(n == 1 || n == 2)
            return n;
        int b = 1, a = 1, sum = 0;
        for(int i = 1; i < n; i++){
            sum = a + b;
            b = a;
            a = sum;
        }
        return sum;
    }

    public int climbStairsDP(int n) {
        if(n == 1 || n == 2)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
