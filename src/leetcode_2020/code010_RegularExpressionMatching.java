package leetcode_2020;

public class code010_RegularExpressionMatching
{
    //    递归
    public static boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;
        boolean isFirstMatch = false;
        if (!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'))
            isFirstMatch = true;
        if (p.length() >= 2 && p.charAt(1) == '*')
            return isMatch(s, p.substring(2)) || (isFirstMatch && isMatch(s.substring(1), p));
        return isFirstMatch && isMatch(s.substring(1), p.substring(1));
    }


    //    记忆法
    public static boolean isMatch1(String s, String p){
        if (s.equals(p))
            return true;
        boolean[] memory = new  boolean[s.length() + 1];
        return helper(s.toCharArray(), p.toCharArray(), s.length() - 1, p.length() - 1, memory);
    }
    public static boolean helper(char[] s, char[] p, int i, int j, boolean[] memory){
        if (memory[i + 1])
            return true;
        if (i == -1 && j == -1){
            memory[i + 1] = true;
            return true;
        }
        boolean isFirstMatching = false;
        if (i >= 0 && j >= 0 && (s[i] == p[j] || p[j] == '.' || (p[j] == '*' && (s[i] == p[j - 1] || p[j - 1] == '.'))))
            isFirstMatching = true;
        if (j >= 0 && p[j] == '*'){
            boolean zero = helper(s, p, i, j - 2, memory);
            boolean match = isFirstMatching && helper(s, p, i - 1, j, memory);
            if (zero || match)
                memory[i + 1] = true;
            return memory[i + 1];
        }
        if (isFirstMatching && helper(s, p, i - 1, j - 1, memory)){
            memory[i + 1] = true;
        }
        return memory[i + 1];
    }

    // 动态规划
    public static boolean isMatch2(String s, String p){
        if (s.equals(p))
            return true;
        char[] sA = s.toCharArray();
        char[] pA = p.toCharArray();
        boolean[][] dp = new boolean[sA.length + 1][pA.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < p.length() + 1; i++)
        {
            dp[0][i] = pA[i - 1] == '*' ? dp[0][i - 2] : false;
        }
        for (int i = 1; i < sA.length + 1; i++)
        {
            for (int j = 1; j < pA.length + 1; j++)
            {
                if (sA[i - 1] == pA[j - 1] || pA[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                if (pA[j - 1] == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (pA[j - 2] == sA[i - 1] || pA[j - 2] == '.')
                        dp[i][j] |= dp[i - 1][j];
                }
            }
        }
        return dp[sA.length][pA.length];
    }
    public static void main(String[] args){
        System.out.println(isMatch2("aab", "ab."));
    }
}
