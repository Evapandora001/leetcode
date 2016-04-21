/**  
 * @Title: DemoDay.java
 * @Prject: exercise
 * @Package: microsoft
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月7日 上午9:08:33
 */
package microsoft;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DemoDay {

	public static void main(String[] args) {
		// Scanner cin = new Scanner(System.in);
		Scanner cin = null;
		try {
			cin = new Scanner(new File("ms//in"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int M = cin.nextInt();
		int N = cin.nextInt();
		cin.nextLine();// 吸收 换行符
		char[][] matrix = new char[M][N];
		for (int i = 0; i < M; i++) {
			matrix[i] = cin.nextLine().toCharArray();
			System.out.println(Arrays.toString(matrix[i]));
		}
		// 0 -> 1 ↓
		int[][][] grid = new int[M][N][2];

		// init 00
		if (matrix[0][0] == 'b') {
			grid[0][0][0] = 1;
		}
		grid[0][0][1] = grid[0][0][0] + ((N == 1 || matrix[0][1] == 'b') ? 0 : 1);
		// init first line
		for (int j = 1; j < N; j++) {
			grid[0][j][0] = grid[0][j - 1][0] + ((matrix[0][j] == 'b') ? 1 : 0);
			grid[0][j][1] = grid[0][j - 1][0] + ((j + 1 == N || matrix[0][j + 1] == 'b') ? 0 : 1)
					+ (matrix[0][j] == 'b' ? 1 : 0);
		}
		// init first column
		for (int i = 1; i < M; i++) {
			grid[i][0][1] = grid[i - 1][0][1] + ((matrix[i][0] == 'b') ? 1 : 0);
			grid[i][0][0] = grid[i - 1][0][1] + ((i + 1 == M || matrix[i + 1][0] == 'b') ? 0 : 1)
					+ ((matrix[i][0] == 'b') ? 1 : 0);
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				grid[i][j][0] = Math.min(grid[i][j - 1][0],
						grid[i - 1][j][1] + ((i + 1 == M || matrix[i + 1][j] == 'b') ? 0 : 1))
						+ (matrix[i][j] == 'b' ? 1 : 0);
				grid[i][j][1] = Math.min(grid[i - 1][j][1],
						grid[i][j - 1][0] + (j + 1 == N || matrix[i][j + 1] == 'b' ? 0 : 1))
						+ (matrix[i][j] == 'b' ? 1 : 0);
			}
		}

		System.out.println(Math.min(grid[M - 1][N - 1][0], grid[M - 1][N - 1][1]));
	}

}
