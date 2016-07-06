/**  
 * @Title: BinarySearchTreeToDoublyLinkedList.java
 * @Prject: leetcode
 * @Package: swordToOffer
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年7月6日 下午4:18:40
 */
package swordToOffer;

/**
 * @ClassName: BinarySearchTreeToDoublyLinkedList
 * @Description: 剑指offer P152 将 二叉搜索树 转化为 有序的 双向链表
 * @author: Evapandora
 * @date: 2016年7月6日 下午4:18:40
 */
public class BinarySearchTreeToDoublyLinkedList {

	class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		public BinaryTreeNode(int val) {
			this.val = val;
		}
	}

	public BinaryTreeNode convertToDoublyLinkedList(BinaryTreeNode root) {
		if (root == null)
			return root;
		BinaryTreeNode pre = null;
		pre = convertToDoublyLinkedList(root, pre);
		while (pre.left != null)
			pre = pre.left;
		return pre;
	}

	/**
	 * @Title: convertToDoublyLinkedList
	 * @Description: TODO
	 * @param root
	 *            根节点
	 * @param pre
	 *            该根节点 前一个 节点
	 * @return: BinaryTreeNode 该树下 最后一个被 遍历 的节点
	 */
	public BinaryTreeNode convertToDoublyLinkedList(BinaryTreeNode root, BinaryTreeNode pre) {
		if (root == null)
			return pre;
		pre = convertToDoublyLinkedList(root.left, pre);
		root.left = pre;
		if (pre != null)
			pre.right = root;
		pre = root;
		return convertToDoublyLinkedList(root.right, pre);
	}

	public static void main(String[] args) {
		BinarySearchTreeToDoublyLinkedList a = new BinarySearchTreeToDoublyLinkedList();
		BinaryTreeNode root = a.new BinaryTreeNode(10);
		root.left = a.new BinaryTreeNode(6);
		root.right = a.new BinaryTreeNode(14);

		root.left.left = a.new BinaryTreeNode(4);
		root.left.right = a.new BinaryTreeNode(8);

		root.right.left = a.new BinaryTreeNode(12);
		root.right.right = a.new BinaryTreeNode(16);

		root = a.convertToDoublyLinkedList(root);
		a.printDoubleLinkedList(root);
	}

	public void printDoubleLinkedList(BinaryTreeNode head) {
		while (head.right != null) {
			System.out.print(head.val + "\t");
			head = head.right;
		}
		System.out.print(head.val);
		System.out.println();
		while (head.left != null) {
			System.out.print(head.val + "\t");
			head = head.left;
		}
		System.out.print(head.val);
	}

}
