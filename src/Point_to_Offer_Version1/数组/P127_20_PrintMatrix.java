package Point_to_Offer_Version1.数组;

import java.util.ArrayList;
import java.util.List;

public class P127_20_PrintMatrix
{
    /*
    * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    * */
    static List<Integer> res = new ArrayList<>();
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        int[] result = new int[matrix.length * matrix[0].length];
        int start = 0, columns = matrix[0].length, rows = matrix.length;
        while (columns > start * 2 && rows > start * 2){
            PrintMatrixInCircle(matrix, columns, rows, start);
            start++;
        }
        for (int i = 0; i < res.size(); i++)
        {
            result[i] = res.get(i);
        }
        return result;
    }

    private static void PrintMatrixInCircle(int[][] matrix, int columns, int rows, int start)
    {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        // 从左到右
        for (int i = start; i <= endX; i++)
        {
            int number = matrix[start][i];
            res.add(number);
        }
        // 从上到下
        if (start < endY){
            for (int i = start + 1; i <= endY; i++)
            {
                int number = matrix[i][endX];
                res.add(number);
            }
        }
        // 从右到左
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--)
            {
                int number = matrix[endY][i];
                res.add(number);
            }
        }
        // 从下到上
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1; i--)
            {
                int number = matrix[i][start];
                res.add(number);
            }
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1},
                {5},
                {9}
        };
        int[] result = new int[matrix.length * matrix[0].length];
        result = spiralOrder(matrix);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(String.valueOf(result[i]) + ",");
        }
    }
}
