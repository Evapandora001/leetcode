package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/**
 *奇慢无比 需要优化 
 *
 */
public class FourSum {
	
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//    	List<List<Integer>> res=new LinkedList<List<Integer>>();
//    	if(nums.length<4) return res;
//    	Arrays.sort(nums);
//    	for(int seed=0;seed<nums.length-3;seed++){
//    		int tar=target-nums[seed];//turn 4Sum to 3Sum
//    		if(seed!=0&&nums[seed]==nums[seed-1]) continue;//delete repetition
//    		for(int i=seed+1;i<nums.length-2;i++){
//    			if(i!=seed+1&&nums[i]==nums[i-1]) continue;//delete repetition
//    			int newTar=tar-nums[i];
//        		int left=i+1,right=nums.length-1;//guarantee the three numbers are different
//        		while (left<right) {
//    				if(nums[left]+nums[right]==newTar){
//    					res.add(Arrays.asList(nums[seed],nums[i],nums[left],nums[right]));
//    					left++;
//    					right--;
//    					while(left<nums.length&&nums[left]==nums[left-1]) left++;
//    					while(right>1&&nums[right]==nums[right+1]) right--;
//    				}else{
//    					if(nums[left]+nums[right]>newTar){
//    						do {
//    							right--;
//    						} while (right>1&&nums[right]==nums[right+1]);
//
//    					}else{
//    						do {
//    							left++;
//    						} while (left<nums.length&&nums[left]==nums[left-1]);
//    					}
//    				}
//    			}
//    		}
//    	}
//    	return res;
//    }

	public static void main(String[] args) {
		FourSum a=new FourSum();
		int nums[]={-4,-1,-1,0,1,2};
		int target=-1;
		for (List<Integer> ele :a.fourSum(nums,target)) {
			System.out.println(ele.toString());
		}
	}
	//稍微快了点 但还是慢
	public List<List<Integer>> fourSum(int[] nums, int target) {
	    List<List<Integer>> res = new LinkedList<List<Integer>>();
	    if (nums == null || nums.length < 4)
	        return res;
	    Arrays.sort(nums);

	    for (int s = 0; s < nums.length - 3; s++) {
	        if (s != 0 && nums[s] == nums[s - 1])  continue;

	        for (int e = nums.length - 1; e >= s + 3; e--) {
	            if (e != nums.length - 1  && nums[e] == nums[e + 1]) continue;

	            int newTar = target - nums[s] - nums[e];
	            int left = s + 1;
	            int right = e - 1;
	            while (left < right) {
    				if(nums[left]+nums[right]==newTar){
					res.add(Arrays.asList(nums[s],nums[left],nums[right],nums[e]));
					left++;
					right--;
					while(left<nums.length&&nums[left]==nums[left-1]) left++;
					while(right>1&&nums[right]==nums[right+1]) right--;
				}else{
					if(nums[left]+nums[right]>newTar){
						do {
							right--;
						} while (right>1&&nums[right]==nums[right+1]);

					}else{
						do {
							left++;
						} while (left<nums.length&&nums[left]==nums[left-1]);
					}
				}
	            }
	        }
	    }
	    return res;
	}
}
