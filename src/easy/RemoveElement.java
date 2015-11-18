package easy;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
    	int count=0,insert=0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=val){
        		nums[insert]=nums[i];
        		count++;
        		insert++;
        	}
        }
    	return count;
    }

	public static void main(String[] args) {
		RemoveElement a=new RemoveElement();
		int nums[]={1,2,3,4,5,6,7};
		System.out.println(a.removeElement(nums, 8));
		System.out.println(Arrays.toString(nums));
	}

}
