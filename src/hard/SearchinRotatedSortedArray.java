package hard;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<right){
        	int mid=(left+right)/2;
        	if(nums[mid]>nums[right]){
        		left=mid+1;
        	}else{
        		right=mid;
        	}
        }
        int pivot=left;//345 012 pivot=3---->012 345
        left=0;
        right=nums.length-1;
        int n=nums.length;
        while(left<=right){
        	int mid=(left+right)/2;
        	if(nums[(mid+pivot)%n]==target){
        		return (mid+pivot)%n;
        	}else{
        		if(nums[(mid+pivot)%n]<target){
        			left=mid+1;
        		}else{
        			right=mid-1;
        		}
        	}
        }
        return -1;
    }

	public static void main(String[] args) {
		SearchinRotatedSortedArray a=new SearchinRotatedSortedArray();
		System.out.println(a.search(new int[]{3,4,5,0,1,2},3));
		System.out.println(a.search(new int[]{3,4,5,0,1,2},0));
		System.out.println(a.search(new int[]{3,4,5,0,1,2},2));
		System.out.println(a.search(new int[]{3,4,5,0,1,2},6));

	}

}
