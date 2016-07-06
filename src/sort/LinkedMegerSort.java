/**  
 * @Title: LinkedMegerSort.java
 * @Prject: leetcode
 * @Package: sort
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年6月24日 上午11:29:20
 */
package sort;


/**
 * @ClassName: LinkedMegerSort
 * @Description: 单向链表的 归并排序实现
 * @author: Evapandora
 * @date: 2016年6月24日 上午11:29:20
 */
public class LinkedMegerSort {
	class ListNode {
		ListNode next;
		int val;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode megerSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid = getMidOfLinkedList(head);
		ListNode right = megerSort(mid.next);
		mid.next = null;
		ListNode left = megerSort(head);
		return meger(left, right);
	}

	private ListNode meger(ListNode left, ListNode right) {
		ListNode head = new ListNode(-1), p = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				p.next = left;
				left = left.next;
			} else {
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if(left != null) p.next = left;
		else p.next = right;
		return head.next;
	}

	// 获取head 的 中间 前一个 指针
	private ListNode getMidOfLinkedList(ListNode head) {
		ListNode walker = head, runner = head.next;
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}
		return walker;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		LinkedMegerSort a = new LinkedMegerSort();
		ListNode head = a.new ListNode(2);
		head.next = a.new ListNode(1);
		head.next.next = a.new ListNode(1);
		head.next.next.next = a.new ListNode(1);
		System.out.println("Before : ");
		a.printLinkedList(head);
		head = a.megerSort(head);
		System.out.println("After : ");
		a.printLinkedList(head);
	}

	public void printLinkedList(ListNode head) {
		if (head == null) {
			System.out.println();
			return;
		}
		while (head.next != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.print(head.val);
		System.out.println();
	}

}
