/**  
 * @Title: BinaryTreeLevelOrderTraversalII.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 下午10:16:54  
 */
package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: BinaryTreeLevelOrderTraversalII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 下午10:16:54
 */
public class BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root == null){
        	return res;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int count=queue.size();
        	LinkedList<Integer> ele=new LinkedList<Integer>();
        	while(count!=0){
        		TreeNode t=queue.remove();
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
        
        if(res.size()>=2){
        	List<List<Integer>> resInversed=new ArrayList<List<Integer>>();
        	while(res.size()!=0){
        		resInversed.add(res.remove(res.size()-1));
        	}
        	return resInversed;
        }else{
        	return res;
        }
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
