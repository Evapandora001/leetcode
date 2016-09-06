/**  
 * @Title: HeapSort.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年8月8日 下午10:05:41  
 */
package datastructure;

import java.util.Arrays;

/**
 * @ClassName: HeapSort
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年8月8日 下午10:05:41
 */
public class HeapSort {
	public int heapsize;

	public int getHeapsize() {
		return heapsize;
	}

	public void setHeapsize(int heapsize) {
		this.heapsize = heapsize;
	}

	public int parents(int i) {
		return (i - 1) / 2;
	}

	public int lChild(int i) {
		return 2 * i + 1;
	}

	public int rChild(int i) {
		return 2 * i + 2;
	}

	public void buildHeap(int[] nums) {
		setHeapsize(nums.length);
		for (int i = parents(getHeapsize() - 1); i >= 0; --i)
			maxModify(nums, i);
	}

	public void maxModify(int[] nums, int i) {
		int l = lChild(i);
		int r = rChild(i);
		int max = i;
		if (l < getHeapsize() && nums[l] > nums[max])
			max = l;
		if (r < getHeapsize() && nums[r] > nums[max])
			max = r;
		if (max != i) {
			nums[i] ^= nums[max];
			nums[max] ^= nums[i];
			nums[i] ^= nums[max];
			maxModify(nums, max);
		}
	}

	public void heapSort(int[] nums) {
		buildHeap(nums);
		for (int i = nums.length - 1; i > 0; --i) {
			nums[i] ^= nums[0];
			nums[0] ^= nums[i];
			nums[i] ^= nums[0];

			setHeapsize(getHeapsize() - 1);
			maxModify(nums, 0);
		}
	}

	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int[] nums = { 19, 9, 4, 3, 4, 56, 345, 7, 3, 23, 6754, 245, 5376, 6472435, 3434, 4, 1, 2, 4, 5 };
		new HeapSort().heapSort(nums);

		System.out.println(Arrays.toString(nums));

	}

}
