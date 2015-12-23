/**  
 * @Title: SortColors.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月23日 下午3:37:30
 */
package medium;

import java.util.Arrays;

/**
 * @ClassName: SortColors
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月23日 下午3:37:30
 */
public class SortColors {
	
    public void sortColors(int[] nums) {
        int zero=0,one=0;
        for(int i=0;i<nums.length;i++){
        	switch(nums[i]){
        	case 0:
        		if(zero==i){
        			zero++;
        			break;
        		}else{
        			if(nums[zero]==1){
        				nums[zero]=0;
        				zero++;
        				nums[i]=1;//接着执行case 1
        				one--;
        			}else{
        				nums[zero]=0;
        				zero++;
        				nums[i]=2;
        				break;
        			}
        		}
        	case 1:
        		if(zero+one==i){
        			one++;
        			break;
        		}else{
        			nums[zero+one]=1;
        			one++;
        			nums[i]=2;
        		}
        	case 2:
        		;
        	}
//        	System.out.println(Arrays.toString(nums));
        }
    }

	public static void main(String[] args) {
		SortColors a=new SortColors();
		int[] nums={0,1,2,0,2,1,0,1,2};
		a.sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}

}
