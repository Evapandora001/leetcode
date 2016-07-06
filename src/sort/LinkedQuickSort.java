/**  
 * @Title: LinkedQuickSort.java
 * @Prject: leetcode
 * @Package: sort
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年6月24日 上午10:36:14
 */
package sort;

/**
 * @ClassName: LinkedQuickSort
 * @Description: 单向链表的快排实现
 * @author: Evapandora
 * @date: 2016年6月24日 上午10:36:14
 */
public class LinkedQuickSort {
	class ListNode {
		ListNode next;
		int val;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode quickSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode leftHead = new ListNode(-1), left = leftHead;
		ListNode midHead = new ListNode(-1), mid = midHead;
		ListNode rightHead = new ListNode(-1), right = rightHead;
		int pivot = head.val;
		while (head != null) {
			if (head.val == pivot) {
				mid.next = head;
				mid = mid.next;
			} else {
				if (head.val < pivot) {
					left.next = head;
					left = left.next;
				} else {
					right.next = head;
					right = right.next;
				}
			}
			head = head.next;
		}
		left.next = null;
		mid.next = null;
		right.next = null;
		left = quickSort(leftHead.next);
		right = quickSort(rightHead.next);
		return meger(left, midHead.next, right);
	}

	public ListNode meger(ListNode left, ListNode mid, ListNode right) {
		ListNode head = new ListNode(-1), p = head;
		// while (left != null) {
		// p.next = left;
		// p = p.next;
		// left = left.next;
		// }
		// while (mid != null) {
		// p.next = mid;
		// p = p.next;
		// mid = mid.next;
		// }
		p = connect(p, left);
		p = connect(p, mid);
		p.next = right;
		return head.next;
	}

	public ListNode connect(ListNode tail, ListNode head) {
		while (head != null) {
			tail.next = head;
			head = head.next;
			tail = tail.next;
		}
		return tail;
	}

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		LinkedQuickSort a = new LinkedQuickSort();
		ListNode head = a.new ListNode(2);
		head.next = a.new ListNode(1);
		head.next.next = a.new ListNode(5);
		head.next.next.next = a.new ListNode(4);
		System.out.println("Before : ");
		a.printLinkedList(head);
		 head = a.quickSort(head);
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
//		head.val = 3;//for test 类的引用
	}

}
