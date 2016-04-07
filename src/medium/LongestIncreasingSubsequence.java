/**  
 * @Title: LongestIncreasingSubsequence.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月7日 下午10:10:07  
 */
package medium;

import java.util.Arrays;

/**
 * @ClassName: LongestIncreasingSubsequence
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月7日 下午10:10:07
 */
public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;
/**
 * Searches a range of the specified array of ints for the specified value using the binary search algorithm. The range must be sorted (as by the sort(int [], int, int) method) prior to making this call. If it is not sorted, the results are undefined. If the range contains multiple elements with the specified value, there is no guarantee which one will be found.

Parameters:
a the array to be searched
fromIndex the index of the first element (inclusive) to be searched
toIndex the index of the last element (exclusive) to be searched
key the value to be searched for
Returns:
index of the search key, if it is contained in the array within the specified range; otherwise, (-(insertion point) - 1). The insertion point is defined as the point at which the key would be inserted into the array: the index of the first element in the range greater than the key, or toIndex if all elements in the range are less than the specified key. Note that this guarantees that the return value will be >= 0 if and only if the key is found.
Throws:
IllegalArgumentException - if fromIndex > toIndex
ArrayIndexOutOfBoundsException - if fromIndex < 0 or toIndex > a.length
Since:
1.6
 */
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(x+"\t"+i);
            if(i < 0) i = -(i + 1);// i 为 插入位置
            dp[i] = x;// i > 0 则说明 元素重复
            if(i == len) len++;
            System.out.println(Arrays.toString(dp));
        }

        return len;
    }
	
	public static void main(String[] args) {
		LongestIncreasingSubsequence aIncreasingSubsequence = new LongestIncreasingSubsequence();
		aIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18,1,102});
	}

}
