/**  
 * @Title: BinaryTreeLevelOrderTraversal.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 上午9:20:22
 */
package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @ClassName: BinaryTreeLevelOrderTraversal
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 上午9:20:22
 */
public class BinaryTreeLevelOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(root==null){
			return res;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			int count=queue.size();
			List<Integer> ele=new LinkedList<Integer>();
			while(count!=0){
				TreeNode t=queue.poll();
				ele.add(t.val);
				if(t.left!=null){
					queue.add(t.left);
				}
				if(t.right!=null){
					queue.add(t.right);
				}
				count--;
			}
			res.add(ele);
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
		// TODO Auto-generated method stub

	}

}
