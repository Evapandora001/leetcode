/**  
 * @Title: UniqueBinarySearchTreesII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月23日 下午4:26:14
 */
package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import medium.BinaryTreeInorderTraversal.TreeNode;

/**
 * @ClassName: UniqueBinarySearchTreesII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月23日 下午4:26:14
 */
public class UniqueBinarySearchTreesII {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		}
	/**
	 * 
二叉查找树（英语：Binary Search Tree），也称二叉搜索树、有序二叉树（英语：ordered binary tree），排序二叉树（英语：sorted binary tree），
是指一棵空树或者具有下列性质的二叉树：

若任意节点的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
任意节点的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
任意节点的左、右子树也分别为二叉查找树；
没有键值相等的节点。
	 */
	
	public ArrayList<TreeNode> generateTrees(int n) {
		if(n==0){
			return new ArrayList();
		}
        return generateTrees(1, n);//从1作为root开始，到n作为root结束
    }
     
    private ArrayList<TreeNode> generateTrees(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right){
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++){
            ArrayList<TreeNode> lefts = generateTrees(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
            ArrayList<TreeNode> rights = generateTrees(i+1, right);//右子树由[i+1, n]构成
            for (int j = 0; j < lefts.size(); j++){
                for (int k = 0; k < rights.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);//存储所有可能行
                }
            }
        }
        return res;
    }
	
	public List<TreeNode> generateTrees_1(int n) {
		LinkedList<TreeNode> res=new LinkedList<TreeNode>();
		boolean[] used=new boolean[n+1];
		int hit=0;
		for(int i=1; i<=n;i++){
			TreeNode root=new TreeNode(i);
			used[i]=true;
			hit=1;
			TreeNode currentNode=root;
			gTBackTrace(used, currentNode, hit, root, res);
			used[i]=false;
		}
		return res;
    }

	/**
	 * @Title: gTBackTrace
	 * @Description: TODO
	 * @param used
	 * @param leftFlag
	 * @param currentNode
	 * @param hit
	 * @param root
	 * @param res
	 * @return: void
	 */
	private void gTBackTrace(boolean[] used, TreeNode currentNode, int hit, TreeNode root,
			LinkedList<TreeNode> res) {
		if(hit==used.length-1){
			res.add(copyBinaryTree(root));
		}
		for(int i=1;i<used.length;i++){
			if(used[i]==true){
				continue;
			}
			hit++;
			used[i]=true;
			TreeNode newNode=new TreeNode(i);
			if(i<currentNode.val){
				currentNode.left=newNode;
			}else{
				currentNode.right=newNode;
			}
			gTBackTrace(used, newNode, hit, root, res);
			used[i]=false;
			hit--;
			currentNode.left=null;
			currentNode.right=null;
		}
	}

	/**
	 * @Title: deepCopyTree
	 * @Description: TODO
	 * @param root
	 * @return
	 * @return: TreeNode
	 */
	public TreeNode copyBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = copyBinaryTree(root.left);
        newRoot.right = copyBinaryTree(root.right);
        return newRoot;
    }
	
	public TreeNode copyBinaryTreeNorecursive(TreeNode root) {
        Stack<TreeNode> ori = new Stack<TreeNode>();
        Stack<TreeNode> copy = new Stack<TreeNode>();
        TreeNode newRoot = null;
        if(root != null){
            newRoot = new TreeNode(root.val);
            ori.push(root);
            copy.push(newRoot);
        }
         
        while(!ori.isEmpty()){
            TreeNode tmp = ori.pop();
            TreeNode copyTmp = copy.pop();
            if(tmp.left!=null){
                copyTmp.left = new TreeNode(tmp.left.val);
                ori.push(tmp.left);
                copy.push(copyTmp.left);
            }
            if(tmp.right!=null){
                copyTmp.right = new TreeNode(tmp.right.val);
                ori.push(tmp.right);
                copy.push(copyTmp.right);
            }
        }
        return newRoot;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTreesII a=new UniqueBinarySearchTreesII();
		for(TreeNode root:a.generateTrees(0)){
			System.out.println(a.preorderTraversal(root).toString());
		}
	}
	
	
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<Integer> res=new LinkedList<Integer>();
		TreeNode t=root;
		Stack<TreeNode> candidate=new Stack<TreeNode>();
		while(t!=null||!candidate.isEmpty()){
			while(t!=null){
				res.add(t.val);
				candidate.push(t);
				t=t.left;
			}
			t=candidate.pop();
			t=t.right;
		}
        return res;
    }

}
