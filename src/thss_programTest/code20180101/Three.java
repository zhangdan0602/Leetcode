package thss_programTest.code20180101;

import java.util.Scanner;

/**
 * @author:zd
 * @date:2019年1月18日下午1:31:13
 * @parameter
 * @return
 */
public class Three {

	static int count = 0;

	static int move(int[][] qp, int x, int y, int t, int xc, int yc) {
		int r1 = 0, r2 = 0, r3 = 0, r4 = 0, r5 = 0, r6 = 0, r7 = 0, r8 = 0;
		t--;
		// System.out.println(x+" "+y+" "+t);

		if (t >= 0) {
			if (qp[x][y] == 1)
				return 0;
			else if (x == xc && y == yc) {
				if (t == 0)
					return 1;
				else
					return 0;
			} else {

				if (x - 2 >= 1 && y + 1 < qp[1].length)
					r1 = move(qp, x - 2, y + 1, t, xc, yc); // 1

				if (x - 1 >= 1 && y + 2 < qp[1].length)
					r2 = move(qp, x - 1, y + 2, t, xc, yc); // 2

				if (x + 1 < qp.length && y + 2 < qp[1].length)
					r3 = move(qp, x + 1, y + 2, t, xc, yc); // 3

				if (x + 2 < qp.length && y + 1 < qp[1].length)
					r4 = move(qp, x + 2, y + 1, t, xc, yc); // 4

				if (x + 2 < qp.length && y - 1 >= 1)
					r5 = move(qp, x + 2, y - 1, t, xc, yc); // 5

				if (x + 1 < qp.length && y - 2 >= 1)
					r6 = move(qp, x + 1, y - 2, t, xc, yc); // 6

				if (x - 1 >= 1 && y - 2 >= 1)
					r7 = move(qp, x - 1, y - 2, t, xc, yc); // 7

				if (x - 2 >= 1 && y - 1 >= 1)
					r8 = move(qp, x - 2, y - 1, t, xc, yc); // 8

				return r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8;

			}

		}
		// else
		return 0;

	}

	public static void main(String[] args) {
		int m, n, c, x0, y0, i, j;
		Scanner reader = new Scanner(System.in);
		m = reader.nextInt(); // m行n列的棋盘
		n = reader.nextInt();
		c = reader.nextInt(); // c个己方棋子

		x0 = reader.nextInt(); // 骑士坐标
		y0 = reader.nextInt();

		int[][] qp = new int[m + 1][n + 1]; // 对棋盘初始化，1代表己方
		for (i = 1; i <= c - 1; i++) { // 自己方棋子坐标,
			i = reader.nextInt();
			j = reader.nextInt();
			qp[i][j] = 1;
		}

		int xc, yc; // 敌方王的坐标
		xc = reader.nextInt();
		yc = reader.nextInt();

		int t;// 步数
		t = reader.nextInt();
		t++;

		count = move(qp, x0, y0, t, xc, yc);
		System.out.println("result:" + count);

	} // 主函数结束
}
