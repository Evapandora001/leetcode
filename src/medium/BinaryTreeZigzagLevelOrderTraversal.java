/**  
 * @Title: BinaryTreeZigzagLevelOrderTraversal.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 上午9:52:47
 */
package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 上午9:52:47
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}

	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(root==null){
			return res;
		}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		boolean reverse=false;
		while(!queue.isEmpty()){
			int count=queue.size();
			List<Integer> ele=new  LinkedList<Integer>();
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
			if(reverse){
				List<Integer> reversedEle=new  LinkedList<Integer>();
				while(ele.size()!=0){
					reversedEle.add(ele.remove(ele.size()-1));
				}
				res.add(reversedEle);
				reverse=false;
			}else{
				res.add(ele);
				reverse=true;
			}
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
