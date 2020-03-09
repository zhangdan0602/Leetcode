package leetcode_2019.code048_RotateImage;

/**
 * @author:zd
 * @date:2019年1月4日下午3:01:39
 * @parameter
 * @return
 */
public class Main {
	public static void rotate(int[][] matrix) {
		int length = matrix.length;

		// 方法1：X轴翻转；对角线翻转
		// x轴翻转
		for (int i = 0; i < length / 2; i++) {
			// 一半就可以
			swapX(matrix, i, length - 1 - i);
		}
		// 对角线翻转
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				// 双层循环 j < i
				swapD(matrix, i, j);
			}
		}

		// 方法2：对角线翻转；Y轴翻转
		// 对角线翻转
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				// 双层循环 j < i
				swapD(matrix, i, j);
			}
		}
		// y轴翻转
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length / 2; j++) {
				// 双层循环 j为一半
				swapY(matrix, i, j);
			}
		}
	}

	// y轴翻转
	private static void swapY(int[][] matrix, int i, int j) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[i][matrix.length - 1 - j];
		matrix[i][matrix.length - 1 - j] = tmp;
	}

	// 对角线翻转
	private static void swapD(int[][] matrix, int i, int j) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[j][i];
		matrix[j][i] = tmp;

	}

	// x轴翻转，可以直接翻转一行
	private static void swapX(int[][] matrix, int i, int j) {
		int tmp[] = matrix[i];
		matrix[i] = matrix[j];
		matrix[j] = tmp;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(matrix);
	}
}
