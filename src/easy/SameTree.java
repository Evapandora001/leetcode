/**  
 * @Title: SameTree.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月23日 下午11:04:33  
 */
package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: SameTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月23日 下午11:04:33
 */
public class SameTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null || q==null){
			if(p==q){
				return true;
			}else{
				return false;
			}
		}
		if(p.val!=q.val){
			return false;
		}
		return(isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}
	public boolean isSameTree_1(TreeNode p, TreeNode q) {
		if(p==null || q==null){
			if(p==q){
				return true;
			}else{
				return false;
			}
		}
		Queue<TreeNode> pNodes=new LinkedList<TreeNode>();
		Queue<TreeNode> qNodes=new LinkedList<TreeNode>();
		pNodes.add(p);
		qNodes.add(q);
		while(!pNodes.isEmpty()){
			if(pNodes.size()!=qNodes.size()){
				return false;
			}
			TreeNode tempP=pNodes.poll();
			TreeNode tempQ=qNodes.poll();
			if(tempP.val!=tempQ.val){
				return false;
			}
			if(tempP.left!=null){
				pNodes.add(tempP.left);
			}else{
				if(tempQ.left!=null){
					return false;
				}
			}
			if(tempP.right!=null){
				pNodes.add(tempP.right);
			}else{
				if(tempQ.right!=null){
					return false;
				}
			}
			if(tempQ.left!=null){
				qNodes.add(tempQ.left);
			}
			if(tempQ.right!=null){
				qNodes.add(tempQ.right);
			}
		}
		if(qNodes.isEmpty()){
		    return true;
		}
        return false;
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
