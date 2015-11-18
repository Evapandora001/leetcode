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
		// TODO Auto-generated method stub

	}

}
