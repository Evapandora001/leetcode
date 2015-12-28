/**  
 * @Title: RemoveDuplicatesfromSortedList.java
 * @Prject: leetcode
 * @Package: easy
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月28日 下午2:11:10
 */
package easy;


/**
 * @ClassName: RemoveDuplicatesfromSortedList
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月28日 下午2:11:10
 */

public class RemoveDuplicatesfromSortedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null){
    		return head;
    	}
    	ListNode insert=head;
    	ListNode p=head.next;
    	while(p!=null){
    		if(insert.val!=p.val){
    			insert.next=p;
    			insert=p;
    		}
    		p=p.next;
    	}
    	insert.next=null;
    	return head;
    }

    public static void main(String[] args) {
    	RemoveDuplicatesfromSortedList a=new RemoveDuplicatesfromSortedList();
    	ListNode head=a.new ListNode(0);
		head.next=a.new ListNode(0);
		head.next.next=a.new ListNode(1);
		head.next.next.next=a.new ListNode(2);
		head.next.next.next.next=a.new ListNode(3);
		head.next.next.next.next.next=a.new ListNode(3);
		head=a.deleteDuplicates(head);
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
	}
}
