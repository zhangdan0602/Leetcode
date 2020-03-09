package leetcode_2019.code024_SwapNodesinPairs;

public class Main {
	public static ListNode swapPairs(ListNode head) {
		ListNode out=new ListNode(0);
		//next表示：链接后面的链表
		//out=0   out.next=1-2-3-4
		out.next=head;
		//rs=out=0   rs.next=out.next=1-2-3-4
		ListNode rs=out;
		ListNode swap;
		while(rs.next!=null&&rs.next.next!=null){
			
			//先看等号右侧的变化   rs指整个链表／首位的数   重点是2-4句中的链表链接   都是要变化原先的节点的next而且变化时使用的也是原先的节点不断地next
			
			//先定义一个临时变量   rs=0-1-2-3-4   rs.next=1-2-3-4   swap=1-2-3-4   
			swap=rs.next;
			//先链接后者   swap=1-2-3-4   swap.next=2-3-4   rs.next=1-2-3-4变为2-3-4   rs=0-2-3-4
			rs.next=swap.next;
			//前者链接后者的下一者   swap.next.next=3-4   swap=1-2-3-4   swap.next=3-4   swap=1-3-4
			swap.next=swap.next.next;
			//后者链接前者   swap=1-3-4   rs.next=0-2-3-4   rs.next.next=0-2-1-3-4
			rs.next.next=swap;
			//swap=1-3-4   rs=1-3-4   out=0-2-1-3-4
			rs=swap;
			
			/*超时
			rs.next=rs.next.next; 0(rs)链接2
			rs.next.next=rs.next.next.next;1(rs.next)链接3
			rs.next.next=rs.next;2(rs.next)链接1
			rs=rs.next;
			*/
			
		}
		return out.next;
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1234);
		swapPairs(head);
	}
}
