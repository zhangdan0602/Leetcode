package 算法分析与设计.动态规划;

public class LongestValidParentheses
{
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int dp[] = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '(')
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                else if ((i - dp[i - 1] > 0 ) && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            maxLength = Math.max(maxLength, dp[i]);
            System.out.println(dp[i]);
        }
        return maxLength;
    }
    public static void main(String[] args){
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()())"));
    }
}
