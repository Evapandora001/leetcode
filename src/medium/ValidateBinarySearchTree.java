/**  
 * @Title: ValidateBinarySearchTree.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: 二叉搜索树 中序遍历 为 升序
 * @author: Evapandora  
 * @date: 2016年2月23日 下午10:42:29  
 */
package medium;

import java.util.Stack;

/**
 * @ClassName: ValidateBinarySearchTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月23日 下午10:42:29
 */
public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	
	public boolean isValidBST(TreeNode root) {
		boolean flag=true;
		int base=0;
		Stack<TreeNode> candidate=new Stack<TreeNode>();
		TreeNode t=root;
		while(t!=null || !candidate.isEmpty()){
			while(t!=null){
				candidate.push(t);
				t=t.left;
			}
			t=candidate.pop();
			if(flag){
				base=t.val;
				flag=false;
			}else{
				if(base>=t.val){
					return false;
				}
				base=t.val;
			}
			t=t.right;
		}
        return true;
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
