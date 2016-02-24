/**  
 * @Title: ConstructBinaryTreefromInorderandPostorderTraversal.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 下午9:31:39  
 */
package medium;

import java.util.HashMap;

/**
 * @ClassName: ConstructBinaryTreefromInorderandPostorderTraversal
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 下午9:31:39
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	HashMap<Integer, Integer> index=new HashMap<Integer, Integer>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i=0; i<inorder.length; i++){
			index.put(inorder[i], i);
		}
		return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
	/**
	 * @Title: buildTree
	 * @Description: TODO
	 * @param postorder
	 * @param i
	 * @param j
	 * @param inorder
	 * @param k
	 * @param l
	 * @return
	 * @return: TreeNode
	 */
	private TreeNode buildTree(int[] postorder, int i, int j, int[] inorder, int k, int l) {
		if(j<0 || i>j){
			return null;
		}
		int rootVal=postorder[j];
		int rootIndex=index.get(rootVal);
		TreeNode root=new TreeNode(rootVal);
		root.left=buildTree(postorder, i, rootIndex-k-1, inorder, k, rootIndex-1);
		root.right=buildTree(postorder, rootIndex-k, j-1, inorder, rootIndex+1, l);
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
