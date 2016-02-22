/**  
 * @Title: SubsetsII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 下午12:50:30
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SubsetsII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月22日 下午12:50:30
 */
public class SubsetsII {
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		if(nums.length>=2){
			Arrays.sort(nums);
		}
		int count=1;
		for(int i=0;i<nums.length;i++){
			if(i==0||nums[i]!=nums[i-1]){
				int len=res.size();
				for(int j=0;j<len;j++){
					ArrayList<Integer> ele=new ArrayList<Integer>(res.get(j));
					ele.add(nums[i]);
					res.add(ele);
				}
			}else{
				int end=res.size()-1;
				for(int j=0;j<count;j++){//只取不重复部分 进行 add
					ArrayList<Integer> ele=new ArrayList<Integer>(res.get(end-j));
					ele.add(nums[i]);
					res.add(ele);
				}
			}
			if(i==nums.length-1||nums[i]!=nums[i+1]){
				count=res.size();
			}
		}
		return res;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		SubsetsII a=new SubsetsII();
		int[] nums=new int[]{0,1,1};
		List<List<Integer>> res=a.subsetsWithDup(nums);
		System.out.println(res.size());
		for(List<Integer> ele:res){
			System.out.println(ele);
		}
	}

}
