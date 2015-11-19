package medium;

import java.util.Arrays;

public class NextPermutation {
	

	public void nextPermutation(int[] nums) {
    	int left=nums.length-2;
    	for(;left>=0;left--){
    		if(nums[left]<nums[left+1]) break;
    	}
    	if(left<0){
    		for(int i=0;i<nums.length/2;i++){
    			int temp=nums[nums.length-1-i];
    			nums[nums.length-i-1]=nums[i];
    			nums[i]=temp;
    		}
        	System.out.println(Arrays.toString(nums));
			return;
    	}
    	int right=nums.length-1;
    	for(;right>left;right--){
    		if(nums[right]>nums[left]) break;
    	}
    	int temp=nums[right];
    	nums[right]=nums[left];
    	nums[left]=temp;
    	Arrays.sort(nums, left+1,nums.length);
    	System.out.println(Arrays.toString(nums));
    }

	public static void main(String[] args) {
		NextPermutation a=new NextPermutation();
		a.nextPermutation(new int[]{100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
//		a.nextPermutation(new int[]{1,2,3});
//		a.nextPermutation(new int[]{1,5,4,3,2,1});
	}

}
