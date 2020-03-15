package Point_to_Offer_Version1.数组;

public class P38_03_FindInPartiallySortedMatrix
{
    /*
    * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    */
    public static boolean find(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0)
            return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        // 特殊样例，边界条件
        if (matrix != null && rows > 0 && columns > 0){
            int row = 0;
            // 从右上角出发，缩小查询的范围，减少重叠部分
            int column = columns - 1;
            while (row < rows && column >= 0){
                if (matrix[row][column] == target){
                    return true;
                }else if (matrix[row][column] > target){
                    column--;
                }else {
                    row++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(find(matrix, 7));
        System.out.println(find(matrix, 19));
    }
}
