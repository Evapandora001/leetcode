package medium;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
    	if(target<=nums[0]) return 0;
    	if(target>nums[nums.length-1]) return nums.length;
    	int left=0,right=nums.length-1;
    	while(left<=right){
    		int mid=(left+right)/2;
    		if(nums[mid]==target){
    			return mid;
    		}else{
    			if(nums[mid]<target){
    				left=mid+1;
    			}else{
    				right=mid-1;
    			}
    		}
    	}
    	return left;//when while over,right(lower)<left(higher)
    }

	public static void main(String[] args) {
		SearchInsertPosition aInsertPosition=new SearchInsertPosition();
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},7));
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},3));
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},0));
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},9));
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},1));
		System.out.println(aInsertPosition.searchInsert(new int[]{1,3,5,6,8},8));

	}

}
