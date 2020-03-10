package leetcode_2020;

public class code092_ReverseLinkedListII
{
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 1; i < m; i++)
        {
            cur = cur.next;
        }
        head = cur.next;
        for (int i = m; i < n ; i++)
        {
            ListNode nxt = head.next;
            head.next = nxt.next;
            nxt.next = cur.next;
            cur.next = nxt;
        }
        return dummy.next;
    }
}
