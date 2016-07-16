/**  
 * @Title: GetMinNums.java
 * @Prject: leetcode
 * @Package: swordToOffer
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年7月7日 下午4:34:59
 */
package swordToOffer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: GetMinNums
 * @Description: 给定一个数组 拿到 最小的K个数
 * @author: Evapandora
 * @date: 2016年7月7日 下午4:34:59
 */
public class GetMinNums {

	public int[] getMinKNums(int[] nums, int k) {
		if (k <= 0)
			return new int[] {};
		if (k >= nums.length)
			return nums;
		int[] res = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;//大顶堆
				return o1 - o2;//小顶堆
			}
		});
		for(int num : nums){
			pq.offer(num);
			if(pq.size() == k+1){
				pq.remove();
			}
		}
		int index = 0;
		for(int num : pq){
			res[index++] = num;
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
		GetMinNums a = new GetMinNums();
		int[] nums = {10,9,8,7,6,5,4,3,2,1};
		nums = a.getMinKNums(nums, 1);
		System.out.println(Arrays.toString(nums));
	}

}
