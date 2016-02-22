/**  
 * @Title: ReverseLinkedListII.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 下午4:06:18
 */
package medium;


/**
 * @ClassName: ReverseLinkedListII
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月22日 下午4:06:18
 */
public class ReverseLinkedListII {
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode start=new ListNode(0);
		start.next=head;
		int step=1;
		ListNode reversePre=null,reverseNext=null,reverseStart = null,revserseEnd=null;
		ListNode pre=start,p=pre.next,next=p.next;
		while(step<n){
			if(step<m){
				;
			}else{
				if(step==m){
					reversePre=pre;
					reverseStart=p;
				}else{
					p.next=pre;
				}
			}
			pre=p;
			p=next;
			next=next.next;
			step++;
		}
		
		if(reversePre==null){
			printLinkList(head);
			return head;
		}
		
		p.next=pre;
		revserseEnd=p;
		reverseNext=next;
		
		reversePre.next=revserseEnd;
		reverseStart.next=reverseNext;
		
		printLinkList(head);
        return start.next;
    }

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		ReverseLinkedListII a=new ReverseLinkedListII();
		ListNode head=a.new ListNode(1);
		head.next=a.new ListNode(4);
//		head.next.next=a.new ListNode(3);
//		head.next.next.next=a.new ListNode(2);
//		head.next.next.next.next=a.new ListNode(5);
//		head.next.next.next.next.next=a.new ListNode(2);
		a.reverseBetween(head, 2, 2);
	}
	
	public void printLinkList(ListNode head){
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
		System.out.println();
	}

}
