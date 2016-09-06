package wangyi;


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author zkf
 *
 */

public class Second {
	private class Point implements Comparable<Point>{
		final int r, c;
		boolean blocked = false;
		int dist = Integer.MAX_VALUE;
		boolean visited = false;

		private Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		private void visitNeighbors() {
			if (r != 0)
				visit(street[r-1][c], distN[r-1]);
			if (r != n-1)
				visit(street[r+1][c], distN[r]);
			if (c != 0)
				visit(street[r][c-1], distM[c-1]);
			if (c != m-1)
				visit(street[r][c+1], distM[c]);
		}

		private void visit(Point nbr, int len) {
			if (!nbr.visited && !nbr.blocked && nbr.dist > dist + len) {
				queue.remove(nbr);
				nbr.dist = dist + len;
				queue.add(nbr);
			}
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(dist, o.dist);
		}
	}

	private int n, m;
	private int[] distN, distM;
	private Point[][] street;

	public void deal() {
		try(Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextInt()) {
				n = scanner.nextInt();
				m = scanner.nextInt();
				distN = new int[n-1];
				distM = new int[m-1];
				for (int i = 0; i < n - 1; i++) {
					distN[i] = scanner.nextInt();
				}
				for (int i = 0; i < m - 1; i++) {
					distM[i] = scanner.nextInt();
				}

				street = new Point[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						street[i][j] = new Point(i, j);
					}
				}

				int k = scanner.nextInt();
				for (int i = 0; i < k; i++) {
					street[scanner.nextInt()-1][scanner.nextInt() - 1].blocked = true;
				}

				int q = scanner.nextInt();
				for (int i = 0; i < q; i++) {
					System.out.println(minPath(scanner.nextInt()-1, scanner.nextInt()-1,
							scanner.nextInt()-1, scanner.nextInt()-1));
				}
			}
		}
	}

	private PriorityQueue<Point> queue = new PriorityQueue<>();
	private Set<Integer> visited = new HashSet<>();
	private int minPath(int r0, int c0, int r1, int c1) {
		Point start = street[r0][c0], end = street[r1][c1];
		queue.clear();
		visited.clear();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				street[i][j].visited = false;
				street[i][j].dist = Integer.MAX_VALUE;
			}
		}

		start.dist = 0;
		queue.add(start);
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			if (cur == end)
				return cur.dist;

			cur.visited = true;
			cur.visitNeighbors();
		}

		return -1;
	}

	public static void main(String[] args) {
		new Second().deal();
	}
}
