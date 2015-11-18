package easy;


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}

public class MergeTwoSortedLists {
	
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head=new ListNode(0);
//        head.next=null;
//        ListNode p=head;
//        while(l1!=null&&l2!=null){
//    		ListNode node;
//        	if(l1.val<l2.val){
//        		node=new ListNode(l1.val);
//        		l1=l1.next;
//        	}else{
//        		node=new ListNode(l2.val);
//        		l2=l2.next;
//        	}
//        	p.next=node;
//        	node.next=null;
//        	p=p.next;
//        }
//        if(l1!=null){
//        	p.next=l1;
//        }else{
//        	p.next=l2;
//        }
//        return head.next;
//    }

	public static void main(String[] args) {
		MergeTwoSortedLists a=new MergeTwoSortedLists();
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next=new ListNode(5); 
		l1.next.next.next=new ListNode(7);
		
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(4);
		l2.next.next=new ListNode(6); 
		l2.next.next.next=new ListNode(8); 
		
		ListNode res=a.mergeTwoLists(l1, l2);
		while (res!=null) {
			System.out.print(res.val+"\t");
			res=res.next;
		}
	}
	
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	  if(l1==null) return l2;
	  if(l2==null) return l1;
	  if(l1.val<l2.val){
		  l1.next=mergeTwoLists(l1.next, l2);
		  return l1;
	  }else{
		  l2.next=mergeTwoLists(l1, l2.next);
		  return l2;
	  }
  }
}
