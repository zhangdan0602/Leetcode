package 算法分析与设计.动态规划;

public class LongestIncreaseSubSequence
{
    // 不连续
    public int lengthOfLIS1(int[] nums) {
        int maxLength = 0;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            dp[i] = 1;
        }
        for (int i = 0; i < dp.length; i++)
        {
            for (int k = 0; k < i; k++)
            {
                if (nums[i] > nums[k])
                    // dp[i]:以i结尾，最长的递增子序列
                    dp[i] = Math.max(dp[i], dp[k] + 1);
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
    public static void main(String[] args){
        LongestIncreaseSubSequence longestIncreaseSequen = new LongestIncreaseSubSequence();
        //System.out.println(longestIncreaseSequen.lengthOfLIS1(new int[]{2,2}));
        //System.out.println(longestIncreaseSequen.lengthOfLIS1(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(longestIncreaseSequen.lengthOfLIS1(new int[]{4,10,4,3,8,9}));
    }
}
