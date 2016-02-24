/**  
 * @Title: SymmetricTree.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 上午9:04:22
 */
package easy;

/**
 * @ClassName: SymmetricTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 上午9:04:22
 */
public class SymmetricTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	
	public boolean isSymmetric(TreeNode root) {
     if(root==null){   
    	 return true;
     }
     return isSymmetric(root.left, root.right);
    }

	/**
	 * @Title: isSymmetric
	 * @Description: TODO
	 * @param left
	 * @param right
	 * @return
	 * @return: boolean
	 */
	private boolean isSymmetric(TreeNode p, TreeNode q) {
		if(p==null || q==null){
			if(p==null && q==null){
				return true;
			}else{
				return false;
			}
		}
		if(p.val!=q.val){
			return false;
		}
		return(isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left));
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
