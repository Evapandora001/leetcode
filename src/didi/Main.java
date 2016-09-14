package didi;

import java.util.Scanner;

public class Main {

	public static int fun(int b[], int n) {
		int i, max, c;
		c = 0;
		max = Integer.MIN_VALUE;
		for (i = 1; i <= n; i++) {
			if (c > 0)
				c = c + b[i];
			else
				c = b[i];
			if (max < c)
				max = c;
		}
		return max;
	}

	public static void main(String[] args) {
		int i, j, max, sum, k;
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		while ((number--) > 0) {
			int n1 = in.nextInt(), m1 = in.nextInt();
			int[][] a = new int[n1 + 1][m1 + 1];
			int[] b = new int[m1 + 1];

			for (i = 1; i <= n1; i++)
				for (j = 1; j <= m1; j++)
					a[i][j] = in.nextInt();
			max = Integer.MIN_VALUE;
			for (i = 1; i <= n1; i++) {
				for (j = 1; j <= m1; j++)
					b[j] = 0;
				for (j = i; j <= n1; j++) {
					for (k = 1; k <= m1; k++)
						b[k] += a[j][k];
					sum = fun(b, m1);
					if (max < sum)
						max = sum;
				}

			}
			System.out.println(max);
		}
	}
}