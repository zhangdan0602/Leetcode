package code021_MergerTwoSortedLists;


public class Main {
	public static int[] mergeTwoLists(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				nums[k++] = nums1[i++];
			} else {
				nums[k++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			nums[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			nums[k++] = nums2[j++];
		}
		return nums;
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//类似于合并两个有序数组  声明结果链表 不断地延伸
		ListNode rs = new ListNode(0);
		//声明两个链表 遍历
		ListNode p = l1, q = l2, out = rs;
		//遍历两链表中最短的链表，即两链表共有的长度，依次延伸rs
		while (p != null && q != null) {
			if (p.val < q.val) {
				rs.next=p;
				rs = rs.next;
				p = p.next;
			} else {
				rs.next=q;
				rs = rs.next;
				q = q.next;
			}
		}
		//当两链表长度不一时
		
		//两个链表中有一个已经遍历结束，rs中链接未遍历结束的链表即可,有4种方式。while更好理解。
		/*//1.
		while (p != null) {
			rs.next=p;
			rs = rs.next;
			p = p.next;
		}
		while (q != null) {
			rs.next=q;
			rs = rs.next;
			q = q.next;
		}*/
		
		//如果l1短，链接l2。
		/*//2.
		if(p != null) {
			rs.next=p;
		}
		if (q != null) {
			rs.next=q;
		}
		*/
		/*//3.
		 if(p == null) {
			rs.next=q;//有一个疑问，q不一定长。改进为以下方法。
		}
		if (q == null) {
			rs.next=p;
		}
		 */
		//4.
		if(p == null && q != null) {
			rs.next=q;//有一个疑问，q不一定长。
		}
		if (q == null && p != null) {
			rs.next=p; 
		}
		System.out.println(out.val);
		return out.next;
	}

	public static void main(String[] args) {
		mergeTwoLists(new ListNode(124), new ListNode(134));
	}
}
