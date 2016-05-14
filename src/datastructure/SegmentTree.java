/**  
 * @Title: SegmentTree.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年5月3日 下午4:19:14
 */
package datastructure;

/**
 * @ClassName: SegmentTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年5月3日 下午4:19:14
 */
public class SegmentTree {

	private SegmentNode ROOT;
	private int SIZE;

	// [1,2,3,....,10]为例
	class SegmentNode {
		// [1,3]
		int left;// 1
		int right;// 3
		int sum;// 6
		SegmentNode leftNode;// [1,2]
		SegmentNode rightNode;// [3]

		public SegmentNode(int left, int right) {
			this.left = left;
			this.right = right;
		}

	}

	public void constructSegmentTree(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		SIZE = nums.length - 1;
		ROOT = new SegmentNode(0, SIZE);
		constructSegmentNode(ROOT, nums);
	}

	/**
	 * @Title: constructSegmentNode
	 * @Description: 线段树 初始化 构建 数据源于数组
	 * @param root
	 * @param left
	 * @param right
	 * @param nums
	 * @return
	 * @return: int
	 */

	private int constructSegmentNode(SegmentNode root, int[] nums) {
		if (root.left == root.right) {
			root.sum = nums[root.left];
			return root.sum;
		}
		int mid = root.left + ((root.right - root.left) >> 1);
		root.leftNode = new SegmentNode(root.left, mid);
		root.rightNode = new SegmentNode(mid + 1, root.right);
		root.sum = constructSegmentNode(root.leftNode, nums) + constructSegmentNode(root.rightNode, nums);
		return root.sum;
	}

	public int search(int left, int right) {
		if (left > right)
			return 0;
		if (left < 0)
			left = 0;
		if (right > SIZE)
			right = SIZE;
		return search(ROOT, left, right);
	}

	/**
	 * @Title: search
	 * @Description: 线段树查找 左右区间
	 * @param root
	 * @param left
	 * @param right
	 * @return
	 * @return: int
	 */
	private int search(SegmentNode root, int left, int right) {
		if (root.left == left && root.right == right) {
			return root.sum;
		}
		int nodeMid = root.left + ((root.right - root.left) >> 1);
		if (nodeMid >= right) {
			return search(root.leftNode, left, right);
		} else {
			if (left <= nodeMid) {
				return search(root.leftNode, left, nodeMid) + search(root.rightNode, nodeMid + 1, right);
			} else {
				return search(root.rightNode, left, right);
			}
		}
	}

	public void update(int index, int value) {
		if (index < 0 || index > SIZE)
			return;
		update(ROOT, index, value);
	}

	/**
	 * @Title: update
	 * @Description: 线段树更新 sum
	 * @param root
	 * @param index
	 * @param value
	 * @return: void
	 */
	private int update(SegmentNode root, int index, int value) {
		if (root.left == root.right && root.left == index) {
			root.sum = value;
			return value;
		}
		int midNode = root.left + ((root.right - root.left) >> 1);
		if (index <= midNode) {
			root.sum = update(root.leftNode, index, value) + root.rightNode.sum;
		} else {
			root.sum = root.leftNode.sum + update(root.rightNode, index, value);
		}
		return root.sum;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		SegmentTree a = new SegmentTree();
		a.constructSegmentTree(nums);
		System.out.println(a.search(1, 10));
		System.out.println(a.search(0, 10));
		System.out.println(a.search(0, 5));
		a.update(1, 2);
		System.out.println(a.search(0, 10));
	}

}
