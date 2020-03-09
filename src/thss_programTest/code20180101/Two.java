package thss_programTest.code20180101;

import java.util.Scanner;

/**
 * @author:zd
 * @date:2019年1月17日下午8:49:41
 * @parameter
 * @return
 */
public class Two {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(), m = scanner.nextInt();
		int isExp[][] = new int[n][m];
		char input[][] = new char[n][m];
		String string[] = new String[n];
		for (int i = 0; i < n; i++) {
			string[i] = scanner.next();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				input[i][j] = string[i].charAt(j);
			}
		}
		int initX = 0, initY = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (input[i][j] == '0') {
					initX = i;
					initY = j;
					break;
				}
			}
		}
		/*
5 7 
#L##LR# 
##0#RL# 
##R#R## 
#R##RL# 
#######
		 */
		char location = 0;
		while (initX >= 0 && initY >= 0 && initX < n && initY < m) {
			
			if (isExp[initX][initY]==1) {
				input[initX][initY] = '0';
				break;
			}
			if (input[initX][initY] == '0') {
				input[initX][initY] = '-';
				isExp[initX][initY]=1;
				location = 'r';
				initY++;
				if (initY==m) {
					input[initX][initY--] = '0';
					break;
				}
			} else if (input[initX][initY] == 'L' && location == 'r') {
				input[initX][initY] = '/';
				isExp[initX][initY]=1;
				initX--;
				if (initX<0) {
					input[initX++][initY] = '0';
					break;
				}
				location = 'u';
			} else if (input[initX][initY] == 'L' && location == 'l') {
				input[initX][initY] = '/';
				isExp[initX][initY]=1;
				initX++;
				location = 'd';
				if (initX==n) {
					input[initX--][initY] = '0';
					break;
				}
			} else if (input[initX][initY] == 'L' && location == 'u') {
				input[initX][initY] = '\\';
				isExp[initX][initY]=1;
				initY--;
				location = 'l';
				if (initY<0) {
					input[initX][initY++] = '0';
					break;
				}
			} else if (input[initX][initY] == 'L' && location == 'd') {
				input[initX][initY] = '\\';
				isExp[initX][initY]=1;
				initY++;
				location = 'r';
				if (initY==m) {
					input[initX][initY--] = '0';
					break;
				}
			} else if (input[initX][initY] == 'R' && location == 'r') {
				input[initX][initY] = '\\';
				isExp[initX][initY]=1;
				initX++;
				location = 'd';
				if (initX==n) {
					input[initX--][initY] = '0';
					break;
				}
			} else if (input[initX][initY] == 'R' && location == 'l') {
				input[initX][initY] = '\\';
				isExp[initX][initY]=1;
				initX--;
				location = 'u';
				if (initX<0) {
					input[initX++][initY] = '0';
					break;
				}
			} else if (input[initX][initY] == 'R' && location == 'u') {
				input[initX][initY] = '/';
				isExp[initX][initY]=1;
				initY++;
				location = 'r';
				if (initY==m) {
					input[initX][initY--] = '0';
					break;
				}
			} else if (input[initX][initY] == 'R' && location == 'd') {
				input[initX][initY] = '/';
				isExp[initX][initY]=1;
				initY--;
				location = 'l';
				if (initY<0) {
					input[initX][initY++] = '0';
					break;
				}
			} else if (input[initX][initY] == '#' && location == 'r') {
				input[initX][initY] = '-';
				isExp[initX][initY]=1;
				initY++;
				location = 'r';
				if (initY==m) {
					input[initX][initY--] = '0';
					break;
				}
			} else if (input[initX][initY] == '#' && location == 'l') {
				input[initX][initY] = '-';
				isExp[initX][initY]=1;
				initY--;
				location = 'l';
				if (initY<0) {
					input[initX][initY+1] = '0';
					break;
				}
			} else if (input[initX][initY] == '#' && location == 'u') {
				input[initX][initY] = '|';
				isExp[initX][initY]=1;
				initX--;
				location = 'u';
				if (initX<0) {
					input[initX++][initY] = '0';
					break;
				}
			} else if (input[initX][initY] == '#' && location == 'd') {
				input[initX][initY] = '|';
				isExp[initX][initY]=1;
				initX++;
				location = 'd';
				if (initX==n) {
					input[initX--][initY] = '0';
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
	}

}
