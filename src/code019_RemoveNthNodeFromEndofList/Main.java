package code019_RemoveNthNodeFromEndofList;

public class Main {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
/*
		ListNode out = new ListNode(0);
		out.next=head;
		ListNode pListNode = out.next, rs = out;
		int i = 0;
		while (pListNode != null) {
			pListNode = pListNode.next;
			i++;
			if (i > n) {
				rs = rs.next;
			} 
		}
		rs.next=rs.next.next;
		return out.next;
		*/
		/*
		//遍历两遍
		ListNode p=head;
		int count=0;
		while(p!=null){
			//先获得链表长度
			count++;
			p=p.next;
		}
		if (count<=1) {
			return null;
		}
		if (n>count) {
			return head;
		}
		if (n==count) {
			return head.next;
		}
		p=head;
		//被删除节点的序号是 length-n+1；所以一直遍历到要删除节点的前一个位置序号是length-n
		for(int i=0;i<count-n-1;i++){
			p=p.next;
		}
		p.next=p.next.next;
		return head;
		*/
		
		/*
		 //双指针遍历一遍
		 
		 */
		if (head==null) {
			return null;
		}
		ListNode fast=head;
		ListNode slow=head;
		for (int i = 0; i < n; i++) {
			fast=fast.next;
		}
		if (fast==null) {
			head=head.next;
			return head;
		}
		while(fast.next!=null){
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(12345);
		removeNthFromEnd(head, 2);
	}
}
