/**  
 * @Title: Second.java
 * @Prject: leetcode
 * @Package: ms
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年10月10日 下午7:54:56
 */
package ms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName: Second
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年10月10日 下午7:54:56
 */
public class Second {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		String alphas = in.nextLine();
		ArrayList<HashSet<Integer>> dict = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < 26; i++)
			dict.add(new HashSet<Integer>());
		int M = Integer.parseInt(in.nextLine());
		for (int i = 0; i < M; i++) {
			String ele = in.nextLine();
			dict.get(ele.charAt(0) - 'a').add(ele.charAt(1) - 'a');
			dict.get(ele.charAt(1) - 'a').add(ele.charAt(0) - 'a');
		}
		int[] dp = new int[26];
		dp[alphas.charAt(0) - 'a'] = 1;
		for (int i = 1; i < N; i++) {
			int mem = 0;
			for (int j = 0; j < 26; j++) {
				if (!dict.get(alphas.charAt(i) - 'a').contains(j)) {
					mem = Math.max(mem, dp[j] + 1);
				}
			}
			dp[alphas.charAt(i) - 'a'] = mem;
		}
		int del = 0;
		for (int ele : dp)
			del = Math.max(del, ele);
		System.out.println(N - del);
	}

}
