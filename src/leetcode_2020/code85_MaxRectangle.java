package leetcode_2020;

public class code85_MaxRectangle
{
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        int rowLength = matrix.length, colLength = matrix[0].length;
        int[][] left = new int[rowLength][colLength];
        int[][] top = new int[rowLength][colLength];
        int[][] dp = new int[rowLength][colLength];
        left[0][0] =  matrix[0][0] - '0';
        top[0][0] =  matrix[0][0] - '0';
        for(int i = 1; i < rowLength; i++){
            if(matrix[i][0] == '0')
                top[i][0] =  0;
            else
                top[i][0] =  top[i - 1][0] + 1;
            left[i][0] =  matrix[i][0] - '0';
        }
        for(int j = 1; j < colLength; j++){
            if(matrix[0][j] == '0')
                left[0][j] = 0;
            else
                left[0][j] = left[0][j - 1] + 1;
            top[0][j] = matrix[0][j] - '0';
        }

        for(int i = 1; i < rowLength; i++){
            for(int j = 1; j < colLength; j++){
                if(matrix[i][j] == '0')
                    left[i][j] = 0;
                else
                    left[i][j] = left[i][j - 1] + 1;
            }
        }
        for(int i = 1; i < rowLength; i++){
            for(int j = 1; j < colLength; j++){
                if(matrix[i][j] == '0')
                    top[i][j] = 0;
                else
                    top[i][j] = top[i - 1][j] + 1;
            }
        }

        int max = 0;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if (top[i][j] == 0){
                    dp[i][j] = 0;
                }
                else{
                    int row = top[i][j];
                    int rowMin = left[i][j];
                    for(int k = 0; k < row; k++){
                        rowMin = Math.min(rowMin, left[i - k][j]);
                        dp[i][j] = Math.max(dp[i][j], rowMin * (k + 1));
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    public void print(int[][] left){
        for (int i = 0; i < left.length; i++)
        {
            for (int j = 0; j < left[i].length; j++)
            {
                System.out.print(String.valueOf(left[i][j]) + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        code85_MaxRectangle maxRectangle = new code85_MaxRectangle();
        System.out.println(maxRectangle.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}
