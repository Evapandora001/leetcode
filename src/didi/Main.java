package didi;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int P = in.nextInt();
		int[][] blocks = new int[N][M];
		int[][] cost = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				blocks[i][j] = in.nextInt();
				cost[i][j] = Integer.MAX_VALUE;
			}
		}
		cost[0][0] = 0;
		// i * M + j (j < M)
		dfs(0, 0, blocks, cost);
		if (cost[0][M - 1] <= P) {
			Stack<Integer> path = new Stack<Integer>();
			int i = 0, j = M - 1;
			while (i != 0 || j != 0) {
				path.add(i * M + j);
				// up
				if (islegal(i - 1, j, blocks) && cost[i - 1][j] == cost[i][j]) {
					i = i - 1;
				} else {
					// down
					if (islegal(i + 1, j, blocks) && cost[i + 1][j] == cost[i][j] - 3) {
						i = i + 1;
					} else {
						// left
						if (islegal(i, j - 1, blocks) && cost[i][j - 1] == cost[i][j] - 1) {
							j = j - 1;
						} else {
							// right
							if (islegal(i, j + 1, blocks) && cost[i][j + 1] == cost[i][j] - 1) {
								j = j + 1;
							}
						}
					}
				}
			}
			StringBuilder paths = new StringBuilder("[0,0]");
			while (!path.isEmpty()) {
				int seed = path.pop();
				paths.append("," + "[" + seed / M + "," + seed % M + "]");
			}
			System.out.println(paths.toString());
		} else {
			System.out.println("Can not escape!");
		}
	}

	private static void dfs(int i, int j, int[][] blocks, int[][] cost) {
		// up
		if (islegal(i - 1, j, blocks)) {
			if (cost[i][j] + 3 < cost[i - 1][j]) {
				cost[i - 1][j] = cost[i][j] + 3;
				dfs(i - 1, j, blocks, cost);
			}
		}
		// down
		if (islegal(i + 1, j, blocks)) {
			if (cost[i][j] < cost[i + 1][j]) {
				cost[i + 1][j] = cost[i][j];
				dfs(i + 1, j, blocks, cost);
			}
		}
		// left
		if (islegal(i, j - 1, blocks)) {
			if (cost[i][j] + 1 < cost[i][j - 1]) {
				cost[i][j - 1] = cost[i][j] + 1;
				dfs(i, j - 1, blocks, cost);
			}

		}
		// right
		if (islegal(i, j + 1, blocks)) {
			if (cost[i][j] + 1 < cost[i][j + 1]) {
				cost[i][j + 1] = cost[i][j] + 1;
				dfs(i, j + 1, blocks, cost);
			}
		}
	}

	private static boolean islegal(int i, int j, int[][] blocks) {
		if (i < 0 || i >= blocks.length)
			return false;
		if (j < 0 || j >= blocks[0].length)
			return false;
		if (blocks[i][j] == 0)
			return false;
		return true;
	}

}
/*
 * 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 */