package 算法分析与设计.动态规划;

public class LongestIncreaseSubString
{
    //连续
    public int LengthOfLISS(int[] nums){
        if (nums == null || nums.length == 0)
            return 0;
        int maxLength = 0;
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
                maxLength = Math.max(maxLength, dp[i] + 1);
            }
            else
                dp[i] = 0;
        }
        return maxLength;
    }
    public static void main(String[] args){
        LongestIncreaseSubString longestIncreaseSubString = new LongestIncreaseSubString();
        System.out.println(longestIncreaseSubString.LengthOfLISS(new int[]{2,2}));
        System.out.println(longestIncreaseSubString.LengthOfLISS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(longestIncreaseSubString.LengthOfLISS(new int[]{4,10,4,3,8,9}));
    }
}
