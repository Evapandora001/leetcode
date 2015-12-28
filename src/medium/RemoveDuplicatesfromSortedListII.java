/**  
 * @Title: RemoveDuplicatesfromSortedListII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月28日 下午2:37:44
 */
package medium;

/**
 * @ClassName: RemoveDuplicatesfromSortedListII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月28日 下午2:37:44
 */
public class RemoveDuplicatesfromSortedListII {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null){
			return head;
		}
        ListNode newHead=new ListNode(0),insert=newHead,pre=head,p=null;
        while(pre!=null){
        	p=pre.next;
        	if(p==null){
        		insert.next=pre;
        		insert=insert.next;
        		break;
        	}
        	if(p.val==pre.val){
        		pre=p.next;
        		while(pre!=null&&pre.val==p.val){//remove 2 or more
        			pre=pre.next;
        		}
        	}else{
        		insert.next=pre;
        		insert=insert.next;
        		pre=p;
        	}
        }
        insert.next=null;
        return newHead.next;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII a=new RemoveDuplicatesfromSortedListII();
    	ListNode head=a.new ListNode(0);
		head.next=a.new ListNode(0);
		head.next.next=a.new ListNode(0);
		head.next.next.next=a.new ListNode(2);
		head.next.next.next.next=a.new ListNode(3);
		head.next.next.next.next.next=a.new ListNode(4);
		head=a.deleteDuplicates(head);
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
	}

}
