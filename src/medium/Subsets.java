/**  
 * @Title: Subsets.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月25日 下午10:54:32  
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Subsets
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月25日 下午10:54:32
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums.length>=2){
        	Arrays.sort(nums);
        }
        for(int i=0;i<nums.length;i++){
        	int seed=nums[i];
        	int times=res.size();
        	for(int j=0;j<times;j++){
        		List<Integer> ele=new ArrayList<Integer>(res.get(j));
        		ele.add(seed);
        		res.add(ele);
        	}
        }
        return res;
    }
    
	public static void main(String[] args) {
		Subsets a=new Subsets();
		int[] nums=new int[]{};
		List<List<Integer>> res=a.subsets(nums);
		System.out.println(res.size());
		for(List<Integer> ele:res){
			System.out.println(ele);
		}
	}

}
