/**  
 * @Title: BinaryTreeInorderTraversal.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月23日 上午10:38:59
 */
package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: BinaryTreeInorderTraversal
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月23日 上午10:38:59
 */
public class BinaryTreeInorderTraversal {
	
	/**
	 * Definition for a binary tree node.
	 * 
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	 
	
	
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> res=new LinkedList<Integer>();
		TreeNode t=root;
		Stack<TreeNode> candidate=new Stack<TreeNode>();
		while(t!=null||!candidate.isEmpty()){
			while(t!=null){
				candidate.push(t);
				t=t.left;
			}
			t=candidate.pop();
			res.add(t.val);
			t=t.right;
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
		BinaryTreeInorderTraversal a=new BinaryTreeInorderTraversal();
		TreeNode root=a.new TreeNode(1);
//		root.left=null;
		root.right=a.new TreeNode(2);
		root.right.left=a.new TreeNode(3);
		System.out.println(a.inorderTraversal(root).toString());
	}

}
