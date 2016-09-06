/**  
 * @Title: ArraySplit.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月12日 下午5:23:00  
 */
package datastructure;

/**
 * @ClassName: ArraySplit
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年8月12日 下午5:23:00
 */
public class ArraySplit {

	public int arraySplit(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;
		System.out.println(sum);
		int tar = sum / 2 + 1;
		int[][] dp = new int[nums.length][tar];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					if (j >= nums[i])
						dp[i][j] = nums[i];
					continue;
				}
				if (j < nums[i])
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
			}
		}
		int weight = tar-1;
		for (int i = dp.length - 1; i >= 0; --i) {
			if(i == 0){
				if(weight >= nums[i]){
					System.out.print(" " + nums[0]);
				}
				continue;
			}
			if(dp[i][weight] == dp[i - 1][weight]){
				;
			}else{
				System.out.print(" " + nums[i]);
				weight -= nums[i];
			}
		}
		System.out.println();
		return dp[nums.length - 1][tar - 1];
	}

	public static void main(String[] args) {
		ArraySplit arraySplit = new ArraySplit();
		int[] nums = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 1423 };
		System.out.println(arraySplit.arraySplit(nums));
	}

}
