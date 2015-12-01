package medium;

import java.util.Arrays;

/**
 * @ClassName: MaximumSubarray
 * @Description: 暴力O(n^2)，divide and conquer ，dynamic programming，greedy
 * @author: lenovo
 * @date: 2015年12月1日 下午3:14:17
 */
public class MaximumSubarray {
//	/**
//	 * @Title: maxSubArray
//	 * @Description: dynamic programming
//	 * @param nums
//	 * @return
//	 * @return: int
//	 */
//    public int maxSubArray(int[] nums) {
//    	if(nums.length==1) return nums[0];
//        int[] localMax=new int[nums.length];// i===>以i结尾的sum最大值
//        int[] globalMax=new int[nums.length];//i====>前i个（包括i）中的sum最大值
//        globalMax[0]=nums[0];
//        localMax[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//        	localMax[i]=Integer.max(localMax[i-1],0)+nums[i];
//        	globalMax[i]=Integer.max(localMax[i],globalMax[i-1]);
//        }
//        return globalMax[nums.length-1];
//    }
	public static void main(String[] args) {
		MaximumSubarray a=new MaximumSubarray();
		System.out.println(a.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
/**
 * @Title: maxSubArray
 * @Description: Greedy
 * Lemma 1: Suppose A[i...j] is the max subarray, then sum(A[i...k]) >= 0, where i <=k < j.
 * Proof. If sum(A[i...k]) < 0, then sum(A[k+1...j]) > sum(A[i...j]), contradiction.
 * @param nums
 * @return
 * @return: int
 */
    public int maxSubArray(int[] nums) {
    	if(nums.length==1) return nums[0];
    	int max=nums[0],sum=nums[0];
        for(int i=1;i<nums.length;i++){
        	if(sum<0){
        		sum=0;
        	}
        	sum+=nums[i];
        	if(sum>max){
        		max=sum;
        	}
        }
        return max;
    }
}
