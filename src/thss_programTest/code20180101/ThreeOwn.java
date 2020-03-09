package thss_programTest.code20180101;

/**
*@author:zd
*@date:2019年1月18日下午4:30:17
*@parameter
*@return
*/
import java.util.Scanner;

/**
 * @author:zd
 * @date:2019年1月18日下午1:31:13
 * @parameter
 * @return
 */
public class ThreeOwn {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt(), n = scanner.nextInt(), c = scanner.nextInt();
		int chess[][] = new int[m][n];
		// 自己2，敌人3，空0,骑士1
		// 骑士
		int x0 = scanner.nextInt() - 1, y0 = scanner.nextInt() - 1;
		chess[x0][y0] = 1;

		for (int i = 0; i < c - 1; i++) {
			int xi = scanner.nextInt() - 1, yi = scanner.nextInt() - 1;
			chess[xi][yi] = 2;
		}
		int xc = scanner.nextInt() - 1, yc = scanner.nextInt() - 1;
		chess[xc][yc] = 3;
		int t = scanner.nextInt();

		int dx[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int dy[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		int count = 0;
		count = knightTrav(t, dx, dy, x0, y0, chess, count, m, n);

		System.out.println(count);
	}

	private static int knightTrav(int t, int[] dx, int[] dy, int x0, int y0, int[][] chess, int count, int m, int n) {
		while (t > 0) {
			for (int sel = 0; sel < 8; sel++) {
				x0 += dx[sel];
				y0 += dy[sel];
				if ((x0 >= 0 && x0 < m) && (y0 >= 0 && y0 < n)) {
					if (chess[x0][y0] == 2) {
						x0 -= dx[sel];
						y0 -= dy[sel];
					} else if (chess[x0][y0] == 3 && t > 1) {
						chess[x0][y0] = 1;
					} else if (chess[x0][y0] == 3 && t == 1) {
						chess[x0][y0] = 1;
						count += 1;
					} else if (chess[x0][y0] == 0 && t > 1) {
						chess[x0][y0] = 1;
					} else if (chess[x0][y0] == 0 && t == 1) {
						chess[x0][y0] = 1;
						knightTrav(t + 1, dx, dy, x0, y0, chess, count, m, n);
					}
				} else {
					x0 -= dx[sel];
					y0 -= dy[sel];
				}
			}
			t--;
		}
		return count;
	}
}
