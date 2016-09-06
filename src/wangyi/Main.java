/**  
 * @Title: Main.java
 * @Prject: leetcode
 * @Package: wangyi
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月2日 下午7:40:29  
 */
package wangyi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String[] data = in.nextLine().split(" ");
			int N = Integer.parseInt(data[0]);
			int X = Integer.parseInt(data[1]);

			data = in.nextLine().split(" ");
			int[] nums = new int[N];
			int SUM = 0;
			for (int i = 0; i < data.length; i++) {
				nums[i] = Integer.parseInt(data[i]);
				SUM += nums[i];
			}
			if(SUM < X){
				System.out.println("-1");
				continue;
			}else{
				if(SUM == X){
					System.out.println(X);
					continue;
				}
			}
			int tar = SUM - X;
			int[][] dp = new int[N][tar + 1];
			for(int i = 0; i < N; i++){
				for(int j = nums[i]; j < tar + 1; j++){
					if(i == 0) dp[i][j] = nums[i];
					else{
						dp[i][j] = Math.max(dp[i-1][j-nums[i]] + nums[i], dp[i-1][j]);
					}
				}
			}
			System.out.println(SUM - dp[N-1][tar]);
		}
	}

}