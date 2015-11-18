package easy;


public class RemoveNthNodeFromEndofList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	int len=0;
    	ListNode p=head;
    	while(p!=null){
    		len++;
    		p=p.next;
    	}
    	if(n<=0||n>len) return head;
    	n=len-n;
    	p=head;
    	ListNode pre=null;
    	while(n>0){
    		pre=p;
    		p=p.next;
    		n--;
    	}
    	if(pre==null){
    		return head.next;
    	}else{
    		pre.next=p.next;
    		p.next=null;
    		return head;
    	}
    }

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList a=new RemoveNthNodeFromEndofList();
		int n=7;
		ListNode head=a.new ListNode(0);
		head.next=a.new ListNode(1);
		head.next.next=a.new ListNode(2);
		head.next.next.next=a.new ListNode(3);
		head.next.next.next.next=a.new ListNode(4);
		head.next.next.next.next.next=a.new ListNode(5);
		head=a.removeNthFromEnd(head, n);
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
		
		
	}

}
