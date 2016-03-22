/**  
 * @Title: InfomationGain.java
 * @Prject: leetcode
 * @Package: exercise
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年3月22日 下午8:00:39  
 */
package exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: InfomationGain
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年3月22日 下午8:00:39
 */
public class InfomationGain {
	
	public List<List<Integer>> sumPath(int sum, int[] nums){
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		LinkedList<Integer> ele = new LinkedList<>();
		backTrace(sum, 0, ele, res,nums);
		return res;
	}

	/**
	 * @Title: backTrace
	 * @Description: TODO
	 * @param sum
	 * @param i
	 * @param ele
	 * @param res
	 * @param nums 
	 * @return: void
	 */
	private void backTrace(int sum, int index, LinkedList<Integer> ele, List<List<Integer>> res, int[] nums) {
		if(sum == nums[index]){
			ele.add(nums[index]);
			res.add(new LinkedList<Integer>(ele));
			return;
		}
		sum = sum - nums[index];
		ele.add(nums[index]);
		int left = index*2 + 1;
		int right = index*2 + 2;
		if(left >= nums.length){
			return;
		}
		backTrace(sum, left, ele, res, nums);
		ele.removeLast();
		if(right >= nums.length){
			return;
		}
		backTrace(sum, right, ele, res, nums);
		ele.removeLast();
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		InfomationGain aGain = new InfomationGain();
		int sum = 22;
		int[] nums = {10,5,12,4,7};
		List<List<Integer>> res = aGain.sumPath(sum, nums);
		for(List<Integer> ele : res){
			System.out.println(ele);
		}

	}

}
