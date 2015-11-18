package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res=new LinkedList<List<Integer>>();
    	if(nums.length<3) return res;
    	Arrays.sort(nums);//ascending
    	for(int i=0;i<nums.length-2;i++){
    		if(i!=0&&nums[i]==nums[i-1])	continue;//delete-repetition
    		int target=0-nums[i];
    		int left=i+1,right=nums.length-1;//guarantee the three numbers are different
    		while (left<right) {
				if(nums[left]+nums[right]==target){
					res.add(Arrays.asList(nums[i],nums[left],nums[right]));
					left++;
					right--;
					while(left<nums.length&&nums[left]==nums[left-1]) left++;
					while(right>0&&nums[right]==nums[right+1]) right--;
				}else{
					if(nums[left]+nums[right]>target){
						do {
							right--;
						} while (right>0&&nums[right]==nums[right+1]);

					}else{
						do {
							left++;
						} while (left<nums.length&&nums[left]==nums[left-1]);
					}
				}
			}
    	}
    	return res;
    }

	public static void main(String[] args) {
		ThreeSum a=new ThreeSum();
		int nums[]={1,1,-1,1,1,1,1,0};
		for (List<Integer> ele :a.threeSum(nums)) {
			System.out.println(ele.toString());
		}
	}

}
