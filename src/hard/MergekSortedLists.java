package hard;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
	}

public class MergekSortedLists {
	
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists.length==0) return null; 
    	ListNode res=mergeKLists(0,lists.length-1,lists);
    	return res;
    }
    

	public ListNode mergeKLists(int left, int right,ListNode[] lists) {
		if(left==right){
			return lists[left];
		}
		int mid=(left+right)/2;
		ListNode l=mergeKLists(left, mid, lists);
		ListNode r=mergeKLists(mid+1, right, lists);
		return merge(l,r);
	}

	public ListNode merge(ListNode l, ListNode r){
		if(l==null) return r;
		if(r==null) return l;
		if(l.val<r.val){
			l.next=merge(l.next, r);
			return l;
		}else{
			r.next=merge(l, r.next);
			return r;
		}
	}


	public static void main(String[] args) {
		MergekSortedLists a=new MergekSortedLists();
		int k=3;
		ListNode[] lists=new ListNode[k];
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next=new ListNode(5); 
		l1.next.next.next=new ListNode(7);
		lists[0]=l1;
		
		ListNode l2=new ListNode(2);
		l2.next=new ListNode(4);
		l2.next.next=new ListNode(6); 
		l2.next.next.next=new ListNode(8); 
		lists[1]=l2;
		
		ListNode l3=new ListNode(2);
		l3.next=new ListNode(4);
		l3.next.next=new ListNode(6); 
		l3.next.next.next=new ListNode(8); 
		lists[2]=l3;
		
		ListNode res=a.mergeKLists(lists);
		while (res!=null) {
			System.out.print(res.val+"\t");
			res=res.next;
		}
	}
}
