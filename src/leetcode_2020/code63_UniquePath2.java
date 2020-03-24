package leetcode_2020;

public class code63_UniquePath2
{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null)
            return 0;
        int len = obstacleGrid.length, col = obstacleGrid[0].length;
        int[][] dp = new int[len][col];
        if(obstacleGrid[0][0] == 1)
            return 0;
        else
            dp[0][0] = 1;
        for(int i = 1; i < len; i++){
            if(obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1){
                dp[i][0] = 1;
            }else{
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < col; i++){
            if(obstacleGrid[0][i] == 0 && dp[0][i - 1] == 1){
                dp[0][i] = 1;
            }else{
                dp[0][i] = 0;
            }
        }
        for(int i = 1; i < len; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[len - 1][col - 1];
    }
    public static void main(String[] args){
        code63_UniquePath2 uniquePath1 = new code63_UniquePath2();
        int input[][]= {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePath1.uniquePathsWithObstacles(input));
    }
}
