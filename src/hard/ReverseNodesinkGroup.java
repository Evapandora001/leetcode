package hard;


public class ReverseNodesinkGroup {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
    public ListNode reverseKGroup(ListNode head, int k) {
		ListNode start=new ListNode(0);
		ListNode kStart=start;
		ListNode headStart=null;
		kStart.next=null;
		int count=0;
		ListNode end = null;
		while(head!=null){
			ListNode insert=new ListNode(head.val);//warn deep copy
			if(count==0){
				end=insert;
				headStart=head;
			}
			insert.next=kStart.next;
			kStart.next=insert;
			count++;
			if(count==k){
				kStart=end;
				count=0;
			}
			head=head.next;
		}
		if(count!=0){
			kStart.next=headStart;//need not reserve
		}
		return start.next;
    }

	public static void main(String[] args) {
		ReverseNodesinkGroup a=new ReverseNodesinkGroup();
		ListNode head=a.new ListNode(1);
		head.next=a.new ListNode(2);
		head.next.next=a.new ListNode(3);
		head.next.next.next=a.new ListNode(4);
		head.next.next.next.next=a.new ListNode(5);
		head.next.next.next.next.next=a.new ListNode(6);
		head.next.next.next.next.next.next=a.new ListNode(7);
		head.next.next.next.next.next.next.next=a.new ListNode(8);
		ListNode res=a.reverseKGroup(head,8);
		while(res!=null){
			System.out.print(res.val);
			res=res.next;
		}

	}

}
