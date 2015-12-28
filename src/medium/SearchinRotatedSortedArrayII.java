/**  
 * @Title: SearchinRotatedSortedArrayII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月28日 上午9:51:54
 */
package medium;

/**
 * @ClassName: SearchinRotatedSortedArrayII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月28日 上午9:51:54
 */
public class SearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
    	if(nums.length==0){
    		return false;
    	}
        int privot=0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]<nums[i-1]){
        		privot=i;
        		break;
        	}
        }
//        System.out.print(privot+"\t");
        int left=0, right=nums.length-1, mid=0;
        while(left<=right){
        	mid=(left+right)/2;
        	if(nums[(mid+privot)%nums.length]==target){
        		return true;
        	}else{
        		if(nums[(mid+privot)%nums.length]<target){
        			left=mid+1;
        		}else{
        			right=mid-1;
        		}
        	}
        }
        return false;
    }
    
	public static void main(String[] args) {
		SearchinRotatedSortedArrayII a=new SearchinRotatedSortedArrayII();
		System.out.println(a.search(new int[]{2,2,2,0,2,2},0));
		System.out.println(a.search(new int[]{3,4,5,0,0,1,2,3},5));
		System.out.println(a.search(new int[]{3,4,5,0,1,1,2},0));
		System.out.println(a.search(new int[]{3,4,5,0,1,2,2},2));
		System.out.println(a.search(new int[]{3,4,5,5,0,1,2},6));
	}

}
