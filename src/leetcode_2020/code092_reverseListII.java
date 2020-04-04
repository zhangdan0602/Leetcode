package leetcode_2020;

/*
* https://leetcode-cn.com/problems/reverse-linked-list-ii/
*
* 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
* */
public class code092_reverseListII
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (m == 1)
            return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode suffix = null;

    public ListNode reverseN(ListNode head, int n)
    {
        if (n == 1)
        {
            suffix = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = suffix;
        return last;
    }
}
