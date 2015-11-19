package medium;

import java.util.Arrays;

public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
    	int start=-1,end=-1;
    	if(target<nums[0]||target>nums[nums.length-1]) return new int[]{start,end};
    	int left=0,right=nums.length-1;
    	while(left<=right){//= is essential 
    		int mid=(left+right)/2;
    		if(nums[mid]==target){
    			start=mid-1;
    			end=mid+1;
    			while(start>=0&&nums[start]==target) start--;
    			while(end<nums.length&&nums[end]==target) end++;
    			return new int[]{start+1,end-1};
    		}else{
    			if(nums[mid]>target){
    				right=mid-1;
    			}else{
    				left=mid+1;
    			}
    		}
   		}
    	return new int[]{start,end};
    }

	public static void main(String[] args) {
		SearchforaRange aRange=new SearchforaRange();
//		System.out.println(Arrays.toString(aRange.searchRange(new int[]{5,7,7,8,8,10},8)));
//		System.out.println(Arrays.toString(aRange.searchRange(new int[]{5,7,7,8,8,10},7)));
		System.out.println(Arrays.toString(aRange.searchRange(new int[]{5,7,7,8,8,10},10)));
		System.out.println(Arrays.toString(aRange.searchRange(new int[]{5,7,7,8,8,10},5)));
		System.out.println(Arrays.toString(aRange.searchRange(new int[]{5,7,7,8,8,10},6)));
	}

}
