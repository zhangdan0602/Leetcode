package leetcode_2020;

public class code62_UniquePath1
{
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++)
        {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }
    public static void main(String[] args){
        code62_UniquePath1 uniquePath1 = new code62_UniquePath1();
        System.out.println(uniquePath1.uniquePaths(3, 2));

    }
}
