/**  
 * @Title: StringKMP.java
 * @Prject: leetcode
 * @Package: tencent
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年4月18日 上午11:09:32
 */
package tencent;

import java.util.LinkedList;

/**
 * @ClassName: StringKMP
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年4月18日 上午11:09:32
 */
public class FirstInterview {

	// 字符串匹配算法
	public String stringKMP(String A, String B) {
		// KMP algorithms
		if (B.equals(""))
			return A;
		if (A.equals(""))
			return null;
		char[] arr = B.toCharArray();
		int[] next = makeNext(arr);

		for (int i = 0, j = 0, end = A.length(); i < end;) {
			if (j == -1 || A.charAt(i) == arr[j]) {
				j++;
				i++;
				if (j == arr.length)
					return A.substring(i - arr.length);
			}
			if (i < end && A.charAt(i) != arr[j])
				j = next[j];
		}
		return null;
	}

	private int[] makeNext(char[] arr) {
		int len = arr.length;
		int[] next = new int[len];

		next[0] = -1;
		for (int i = 0, j = -1; i + 1 < len;) {
			if (j == -1 || arr[i] == arr[j]) {
				next[i + 1] = j + 1;
				if (arr[i + 1] == arr[j + 1])
					next[i + 1] = next[j + 1];
				i++;
				j++;
			}
			if (arr[i] != arr[j])
				j = next[j];
		}

		return next;
	}

	// 给定整形数组A和目标整数t，A相邻元素差绝对值为1，请找到t在A中的第一个位置
	public int getIndex(int[] nums, int target) {
		int test = 0;
		while (test < nums.length) {
			if (nums[test] == target)
				return test;
			test += Math.abs(target - nums[test]);
		}
		return -1;
	}

	public LinkedList<Integer> getIndexList(int[] nums, int target) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		int test = 0;
		while (test < nums.length) {
			if (nums[test] == target){
				res.add(test);
				test++;
			}else{
				test += Math.abs(target - nums[test]);
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
		FirstInterview a = new FirstInterview();
		int[] nums = { 4, 3, 4, 5, 6, 5, 4, 3, 4, 5, 6, 7, 8 };
//		System.out.println(a.getIndex(nums, 2));
//		System.out.println(a.getIndex(nums, 6));
//		System.out.println(a.getIndex(nums, 8));
//		System.out.println(a.getIndex(nums, 9));
		System.out.println(a.getIndex(nums, 5));
		System.out.println(a.getIndexList(nums, 5));
	}

}
