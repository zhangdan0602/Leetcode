package 算法分析与设计.动态规划;

public class coinChange
{
    /*
    * https://leetcode-cn.com/problems/coin-change/
    * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
    */
    public int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++)
        {
            dp[i] = amount + 1;
        }
        for (int i = 1; i < dp.length; i++)
        {
            for (int coin : coins)
            {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
