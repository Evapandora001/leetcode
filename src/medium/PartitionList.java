/**  
 * @Title: PartitionList.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年2月22日 上午9:17:53
 */
package medium;

/**
 * @ClassName: PartitionList
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年2月22日 上午9:17:53
 */
public class PartitionList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}
	
	public ListNode partition(ListNode head, int x) {
		ListNode start=new ListNode(0);
		start.next=head;
		ListNode p=head,insert=start,pre=start;
        while(p!=null){
        	if(p.val<x){
        		if(insert==pre){
        			insert=p;
        		}else{
        			pre.next=p.next;
        			p.next=insert.next;
        			insert.next=p;
        			
        			insert=insert.next;
        			p=pre;
        		}
        	}
        	pre=p;
        	p=p.next;
        	printLinkList(head);
        }
		return start.next;
    }
	
	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		PartitionList a=new PartitionList();
		ListNode head=a.new ListNode(1);
		head.next=a.new ListNode(4);
		head.next.next=a.new ListNode(3);
		head.next.next.next=a.new ListNode(2);
		head.next.next.next.next=a.new ListNode(5);
		head.next.next.next.next.next=a.new ListNode(2);
		head=a.partition(head, 3);
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}

	}
	
	public void printLinkList(ListNode head){
		while(head!=null){
			System.out.print(head.val+"\t");
			head=head.next;
		}
		System.out.println();
	}

}
