/**  
 * @Title: ConstructBinaryTreefromPreorderandInorderTraversal.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 上午10:27:02
 */
package medium;

import java.util.HashMap;

/**
 * @ClassName: ConstructBinaryTreefromPreorderandInorderTraversal
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 上午10:27:02
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}

	
	HashMap<Integer, Integer> index=new HashMap<Integer, Integer>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for(int i=0; i<inorder.length; i++){
			index.put(inorder[i], i);
		}
		return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
	/**
	 * @Title: buildTree
	 * @Description: TODO
	 * @param preorder
	 * @param i
	 * @param j
	 * @param inorder
	 * @param k
	 * @param l
	 * @return
	 * @return: TreeNode
	 */
	private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int k, int l) {
		if(i>=preorder.length || i>j){
			return null;
		}
		int rootVal=preorder[i];
		int rootIndex=index.get(rootVal);
		TreeNode root=new TreeNode(rootVal);
		root.left=buildTree(preorder, i+1, i+rootIndex-k, inorder, k, rootIndex-1);
		root.right=buildTree(preorder, i+rootIndex-k+1, j, inorder, rootIndex+1, l);
		return root;
	}
	/**
	 * @Title: binarySearch
	 * @Description: TODO
	 * @param inorder
	 * @param i
	 * @param length
	 * @return
	 * @return: int
	 */
	private int search(int[] inorder, int left, int right, int target) {
		for(int i=left; i<=right; i++){
			if(inorder[i]==target){
				return i;
			}
		}
		return -1;
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
