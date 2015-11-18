package medium;

import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode start=new ListNode(0);
    	start.next=head;
    	ListNode pre=start;
    	while(head!=null&&head.next!=null){
//    		ListNode post=head.next;
    		pre.next=head.next;
    		head.next=head.next.next;
    		pre.next.next=head;
    		
    		pre=head;
    		head=head.next;
    	}
    	return start.next;
    }

	public static void main(String[] args) {
		SwapNodesinPairs a=new SwapNodesinPairs();
		ListNode l=new ListNode(1);
		l.next=new ListNode(3);
		l.next.next=new ListNode(5); 
		l.next.next.next=new ListNode(7);
		l.next.next.next.next=new ListNode(9);
		ListNode res=a.swapPairs(l);
		while(res!=null){
			System.out.print(res.val+"\t");
			res=res.next;
		}

	}
}
