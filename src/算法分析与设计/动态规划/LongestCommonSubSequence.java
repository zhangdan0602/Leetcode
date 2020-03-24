package 算法分析与设计.动态规划;

public class LongestCommonSubSequence
{
    // 不连续
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null)
            return 0;
        if(text1.length() > text2.length()){
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < dp[0].length; i++)
            dp[0][i] = 0;
        for(int i = 0; i < dp.length; i++)
            dp[i][0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args){
        LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();
        System.out.println(longestCommonSubSequence.longestCommonSubsequence("abcde", "ace"));
    }
}
