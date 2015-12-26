/**  
 * @Title: RemoveDuplicatesfromSortedArrayII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月26日 下午2:24:38  
 */
package medium;

import java.util.Arrays;

/**
 * @ClassName: RemoveDuplicatesfromSortedArrayII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月26日 下午2:24:38
 */
public class RemoveDuplicatesfromSortedArrayII {
	
    public int removeDuplicates(int[] nums) {
     if(nums.length<=1){
    	 return nums.length;
     }
     int insert=1,count=1;
     for(int i=1;i<nums.length;i++){
    	 if(nums[i]!=nums[i-1]){
    		 nums[insert]=nums[i];
    		 insert++;
    		 count=1;
    		 continue;
    	 }
    	 if(count<2){
    		 nums[insert]=nums[i];
    		 insert++;
    		 count++;
    	 }else{
    		 count++;
    	 }
     }
     System.out.println(Arrays.toString(nums));
     return insert;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII a=new RemoveDuplicatesfromSortedArrayII();
		int[] nums=new int[]{1,1,2,2,2,3};
		System.out.println(a.removeDuplicates(nums));
	}

}
