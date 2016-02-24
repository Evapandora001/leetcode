/**  
 * @Title: RecoverBinarySearchTree.java
 * @Prject: leetcode
 * @Package: hard
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月24日 下午4:43:17
 */
package hard;

import java.util.Stack;

/**
 * @ClassName: RecoverBinarySearchTree
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月24日 下午4:43:17
 */
public class RecoverBinarySearchTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	
	/**
	 * @Title: recoverTree
	 * @Description: 一次交换，会产生两个错误，即两个降序；第一个降序的 头，和 第二个 降序的 尾 为 需要交换的元素
	 * @param root
	 * @return: void
	 */
	public void recoverTree(TreeNode root) {
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode t=root, l=null, pre=null, lnext=null;
		boolean start=true;
		int error=0;
		while(!stack.isEmpty() || t!=null){
			while(t!=null){
				stack.push(t);
				t=t.left;
			}
			t=stack.pop();
			if(start){
				start=false;
			}else{
				if(pre.val>t.val){
					if(error==0){
						l=pre;
						lnext=t;
						error++;
					}else {
						int change=t.val;
						t.val=l.val;
						l.val=change;
						return;
					}
					
				}else {
					;
				}
			}
			pre=t;
			t=t.right;
		}
		System.out.println(l.val);
		System.out.println(lnext.val);
		int change=l.val;
		l.val=lnext.val;
		lnext.val=change;
		return;
		
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {

	}

}
