package 算法分析与设计.动态规划;

public class EditDistance
{
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if(len1 * len2 == 0)
            return len1 + len2;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1 + 1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j < len2 + 1; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                int left = dp[i][j - 1] + 1;
                int up = dp[i - 1][j] + 1;
                int cross = dp[i - 1][j - 1];
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    cross -= 1;
                dp[i][j] = Math.min(left, Math.min(up, cross + 1));
            }
        }
        return dp[len1][len2];
    }
}
