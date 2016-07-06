/**  
 * @Title: QucikSort.java
 * @Prject: leetcode
 * @Package: sort
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年6月23日 下午3:23:18
 */
package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: QucikSort
 * @Description: 快排 Input：数组 输出 ：非降序
 * @author: Evapandora
 * @date: 2016年6月23日 下午3:23:18
 */
public class QucikSortAndMegerSort {
	static boolean test = false;

	public static void quickSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		quickSort(nums, 0, nums.length - 1);
	}

	public static void quickSort(int[] nums, int start, int end) {
		int left = start, right = end;
		if (left >= right)
			return;
		if (test) {
			int key = selectPivot(nums, left, right);
			if (key != left) {
				nums[key] ^= nums[left];
				nums[left] ^= nums[key];
				nums[key] ^= nums[left];
			}
		}
		int pivot = nums[left];
		while (left < right) {
			while (left < right && nums[right] >= pivot)
				right--;
			nums[left] = nums[right];
			while (left < right && nums[left] < pivot)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		// System.out.println("\t" + pivot + "\t:\t" + left);
		quickSort(nums, start, left - 1);
		quickSort(nums, left + 1, end);
	}

	public static int selectPivot(int[] nums, int start, int end) {
		int mid = start + (end - start >> 1);
		if (nums[start] >= nums[end] && nums[start] >= nums[mid]) {
			if (nums[end] >= nums[mid])
				return end;
			else
				return mid;
		} else {
			if (nums[start] < nums[end] && nums[start] < nums[mid])
				return (nums[end] >= nums[mid]) ? mid : end;
			else
				return start;
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 34, 35, 567, 46, 454, 46, 2356, 45, 435, 46, 46, 46, 7, 3, 4, 354, 56, 4, 6, 34, 3,
				4723, 45, 765, 258, 46367 };
		// quickSort(nums);
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 1 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 1, 3 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 1, 4, 3 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 1, -2, -5, 4 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 2, 2, 1, 2, 1, 1, 2, 2, 2, 1 };
		megerSort(nums);
		System.out.println(Arrays.toString(nums));

		// Scanner cin = null;
		// try {
		// cin = new Scanner(new File("src//sort//Q5.txt"));
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		// int[] nums = new int[100000];
		// int[] nums1 = new int[100000];
		// for (int i = 0; i < nums.length; i++) {
		// nums[i] = Integer.parseInt(cin.nextLine().trim());
		// nums1[i] = nums[i];
		// }
		// long t0 = System.currentTimeMillis();
		// quickSort(nums);
		// long t1 = System.currentTimeMillis();
		//// test = true;
		//// quickSort(nums1);
		// megerSort(nums1);
		// long t2 = System.currentTimeMillis();
		// System.out.println("Normal Way Of QuickSort : " + (t1 - t0) + " ms");
		// System.out.println("Pivot Select Way Of QuickSort : " + (t2 - t1) + "
		// ms");
		/**
		 * 10 万 Normal Way Of QuickSort : 23 ms Pivot Select Way Of QuickSort :
		 * 10 ms
		 */
	}

	public static void megerSort(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int[] temp = new int[nums.length];
		megerSort(nums, temp, 0, nums.length - 1);
	}

	public static void megerSort(int[] nums, int[] temp, int left, int right) {
		if (left == right)
			return;
		int mid = left + (right - left >> 1);
		megerSort(nums, temp, left, mid);
		megerSort(nums, temp, mid + 1, right);
		int i = left, j = mid + 1, k = left;
		while (i <= mid && j <= right) {
			if (nums[i] <= nums[j])
				temp[k++] = nums[i++];
			else
				temp[k++] = nums[j++];
		}
		while (i <= mid)
			temp[k++] = nums[i++];
		while (j <= right)
			temp[k++] = nums[j++];
		for (i = left; i <= right; i++)
			nums[i] = temp[i];
	}
}
