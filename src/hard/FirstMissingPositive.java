package hard;

import java.util.Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	if(nums==null||nums.length==0) return 1;
    	for(int i=0;i<nums.length;i++){
//    		key: put the num[i] into the right position  
//    		nums[i]==nums[nums[i]-1 means the position to be swapped is already the right position so need not swap
    		if(nums[i]<=0||nums[i]>=nums.length||nums[i]==i+1||nums[i]==nums[nums[i]-1]) continue;
    		int temp=nums[nums[i]-1];
    		nums[nums[i]-1]=nums[i];
    		nums[i]=temp;
    		i--;
    	}
    	System.out.println(Arrays.toString(nums));
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]!=i+1){
    			return i+1;
    		}
    	}
    	return nums.length+1;
    }

	public static void main(String[] args) {
		FirstMissingPositive a=new FirstMissingPositive();
		System.out.println(a.firstMissingPositive(new int[]{3,4,-1,1,1,3}));
		System.out.println(a.firstMissingPositive(new int[]{7,6,5,4,3,2,1}));
		System.out.println(a.firstMissingPositive(new int[]{2}));
		System.out.println(a.firstMissingPositive(new int[]{3,4,-1,1}));
	}

}
