package code002_AddTwoNumbers;

public class Main {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// l1或者l2为空时，直接返回另一者。
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		/*
		 * 最开始：rs和out共用一个地址， 过程：不断操作rs，rs每次都是一个新的结点。在修改链表时，只修改rs这条链，
		 * 最终：将链表结果传给out，out返回head则自动返回所有。 如果不声明rs，直接不断改变out，结果将不会返回一长链。
		 */
		ListNode out = new ListNode(0);
		// 初始化时，l1和l2的头结点分别赋值给p，q。后期不断修改rs
		ListNode p = l1, q = l2, rs = out;
		// 进位 该位上和
		int carry = 0, sum = 0;
		while (p != null || q != null) {
			// l1和l2长度不一时，遍历p和q，可以使用三元运算符返回各自的x和y。
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			sum = x + y + carry;
			if (sum < 10) {
				//  8时，没有进位，不加0的话carry被认为1
				carry = 0;
				// rs存储值
				rs.next = new ListNode(sum % 10);
				rs = rs.next;
			} else {
				// 进位最多为1，9+9+1=19
				carry = 1;
				rs.next = new ListNode(sum % 10);
				rs = rs.next;
			}
			// 继续下一个，一个节点存储一位数字。
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		// 运行到最高位时，如果有进位，需要在加一个节点
		if (carry > 0)
			rs.next = new ListNode(carry);
		return out.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(342);
		ListNode l2 = new ListNode(465);
		addTwoNumbers(l1, l2);

	}
}
