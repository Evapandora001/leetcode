/**  
 * @Title: ConvertSortedArraytoBinarySearchTree.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 下午10:32:59  
 */
package medium;


/**
 * @ClassName: ConvertSortedArraytoBinarySearchTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 下午10:32:59
 */
public class ConvertSortedArraytoBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

	private TreeNode sortedArrayToBST(int[] nums, int i, int j) {
		if(i<0 || i>j){
			return null;
		}
		int val=(i+j)/2;
		TreeNode root=new TreeNode(nums[val]);
		root.left=sortedArrayToBST(nums, i, val-1);
		root.right=sortedArrayToBST(nums, val+1, j);
		return root;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
