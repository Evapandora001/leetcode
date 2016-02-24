/**  
 * @Title: MaximumDepthofBinaryTree.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 上午9:45:16
 */
package easy;

/**
 * @ClassName: MaximumDepthofBinaryTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 上午9:45:16
 */
public class MaximumDepthofBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}

	
	public int maxDepth(TreeNode root) {
        if(root==null){
        	return 0;
        }
        return(Integer.max(maxDepth(root.left), maxDepth(root.right))+1);
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
