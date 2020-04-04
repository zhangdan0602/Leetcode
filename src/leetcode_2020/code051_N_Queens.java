package leetcode_2020;

/*
*https://leetcode-cn.com/problems/n-queens/

*n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
* 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

* */

import java.util.LinkedList;
import java.util.List;

public class code051_N_Queens
{

    List<List<String>> result = new LinkedList<>();

    public int totalNQueens(int n)
    {
        result = solveNQueens(n);
        return result.size();
    }

    public List<List<String>> solveNQueens(int n)
    {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }
        backpack(board, 0);
        return result;
    }

    public void backpack(char[][] board, int row)
    {
        if (board.length == row)
        {
            List<String> list = new LinkedList<>();
            for (char[] s : board)
            {
                list.add(String.valueOf(s));
            }
            result.add(list);
            return;
        }
        for (int col = 0; col < board.length; col++)
        {
            if (!isvalid(board, row, col))
            {
                continue;
            }
            board[row][col] = 'Q';
            backpack(board, row + 1);
            board[row][col] = '.';
        }
    }

    public boolean isvalid(char[][] board, int row, int col)
    {

        for (int i = 0; i < board.length; i++)
        {
            if (board[i][col] == 'Q')
            {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        code051_N_Queens n_queens = new code051_N_Queens();
        // System.out.println(n_queens.solveNQueens(4));
        System.out.println(n_queens.totalNQueens(4));
    }
}
