package easy;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
	
    public int removeDuplicates(int[] nums) {
    	if(nums.length<=1)	return nums.length;
    	int count=1;
    	int insert=1;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]!=nums[i-1]){
        		count++;
        		nums[insert]=nums[i];
        		insert++;
        	}
        }
    	return count;
    }

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray a=new RemoveDuplicatesfromSortedArray();
		int nums[]={1,2,2,3,4,5,5};
		System.out.println(a.removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}

}
