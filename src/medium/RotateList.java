/**  
 * @Title: RotateList.java
 * @Prject: leetcode
 * @Package: medium
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2015年12月2日 上午10:50:01
 */
package medium;


/**
 * @ClassName: RotateList
 * @Description: TODO
 * @author: Evapandora
 * @date: 2015年12月2日 上午10:50:01
 */
public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		}

    public ListNode rotateRight(ListNode head, int k) {//右移K个数字
    	if(head==null||k==0) return head;
    	ListNode end=head;
    	int total=1;
    	ListNode newStart=null;
    	ListNode newEnd=null;
    	while(end.next!=null){
    		total++;
    		end=end.next;
    	}
    	if(k%total==0){
    		return head;
    	}else {
			k=total-k%total;//k means new end position 
		}
    	ListNode p=head;
    	while(p.next!=null){
    		if(k==1){
    			newEnd=p;
    			newStart=p.next;
    			break;
    		}else{
    			p=p.next;
    			k--;
    		}
    	}
    	if(newStart==null){
    		return head;
    	}
    	end.next=head;
    	newEnd.next=null;
    	
    	return newStart;
    }
	public static void main(String[] args) {
		RotateList a=new RotateList();
		ListNode l1=a.new ListNode(1);
		l1.next=a.new ListNode(3);
		l1.next.next=a.new ListNode(5); 
		l1.next.next.next=a.new ListNode(7);

		ListNode res=a.rotateRight(l1,3);
		while (res!=null) {
			System.out.print(res.val+"\t");
			res=res.next;
		}
	}

}
