package code051_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:zd
 * @date:2019年1月5日上午10:38:43
 * @parameter
 * @return
 */
public class Main {
	// n皇后问题是典型的回溯法，即任何两个皇后不能在同一行同一列或同一对角线
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> rs = new ArrayList<List<String>>();
		// 第i个位置存的数表示：row行，Q的列
		int[] queen = new int[n];
		// 在第0行放Q
		placeQueen(queen, 0, n, rs);
		for (int i = 0; i < rs.size(); i++) {
			for (int j = 0; j < rs.get(0).size(); j++) {
				System.out.print(rs.get(i).get(i) + ";");
			}
			System.out.println();
		}
		return rs;
	}

	private static void placeQueen(int[] queen, int row, int n, List<List<String>> rs) {
		// 如果已经填满Q，返回结果
		if (row == n) {
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < n; i++) {
				String str = "";
				for (int col = 0; col < n; col++) {
					if (queen[i] == col) {
						str += "Q";
					} else {
						str += ".";
					}
				}
				list.add(str);
			}
			rs.add(list);
		}
		// 第row个Q开始，从每一列开始遍历
		for (int col = 0; col < n; col++) {
			// 当当前列不满足条件时，查看下一列        
			// 如果在该列不冲突，就添加[满足时才添加，或者先queen[row] = col，再valid]
			if (isValid(queen, row, col)) {
				// 数组中存放：第row个Q所在的列
				queen[row] = col;
				// 继续放下一个Q，即下一行，row+1
				placeQueen(queen, row + 1, n, rs);
			}
		}
	}

	private static boolean isValid(int[] queen, int row, int col) {
		// 与之前已经放好的Q一一比较
		for (int i = 0; i < row; i++) {
			// pos即之前每一Q所在的列
			
			int pos = queen[i];
			// 同一列／右下、左上对角线／左下、右上对角线
			/*
			if (pos==col||Math.abs(col-pos)==row-i) {
				return false;
			}
			*/
			
			// 同一列
			if (pos == col) {
				return false;
			}
			// 右下、左上对角线
			// 上一Q的列 + 这一Q的行 - 前面所有Q个数
			if (pos + row - i == col) {
				return false;
			}
			// 左下、右上对角线
			// 上一Q的列 - 这一Q的行 + 前面所有Q个数
			if (pos - row + i == col) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		solveNQueens(4);
	}
}
