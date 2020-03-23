package 算法分析与设计.动态规划;

public class LongestPalindromeString
{
    public String LongestPalindrome(String s){
        if (s == null || s.length() == 0)
            return s;
        int len = s.length(), maxLength = 1, start = 0;
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = true;
        }
        for (int r = 1; r < len; r++)
        {
            for (int l = 0; l < r; l++)
            {
                if (s.charAt(l) == s.charAt(r)){
                    if (r - l < 3){
                        dp[l][r] = true;
                    }else
                        dp[l][r] = dp[l + 1][r - 1];
                }else
                    dp[l][r] = false;

                if (dp[l][r] == true){
                    if (maxLength <= (r - l + 1)){
                        maxLength = r - l + 1;
                        start = l;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
    public static void main(String[] args){
        LongestPalindromeString longestPalindromeString = new LongestPalindromeString();
        System.out.println(longestPalindromeString.LongestPalindrome("ababd"));
    }
}
