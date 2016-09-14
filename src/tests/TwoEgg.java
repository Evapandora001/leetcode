/**  
 * @Title: TwoEgg.java
 * @Prject: leetcode
 * @Package: tests
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年9月11日 下午8:41:18
 */
package tests;

import java.util.Scanner;

/**
 * @ClassName: TwoEgg
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年9月11日 下午8:41:18
 */
public class TwoEgg {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int N = Integer.parseInt(in.nextLine());
			if (N <= 0) {
				System.out.println("0");
				continue;
			}
			if (N == 1) {
				System.out.println("1");
				continue;
			}
			int[] minNum = new int[N + 1];
			for (int i = 2; i <= N; i++) {
				int min = N;
				for (int j = 1; j <= i; j++) {
					min = Math.min(min, 1 + Math.max(j - 1, minNum[i - j]));
				}
				minNum[i] = min;
			}
			System.out.println(minNum[N]);
		}

	}

}
