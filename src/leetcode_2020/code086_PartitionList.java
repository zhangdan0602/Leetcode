package leetcode_2020;

public class code086_PartitionList
{
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;
        for(ListNode cur = head; cur != null;){
            if (cur.val < x){
                prev1.next = cur;
                cur = cur.next;
                prev1 = prev1.next;
                prev1.next = null;
            }else {
                prev2.next = cur;
                cur = cur.next;
                prev2 = prev2.next;
                prev2.next = null;
            }
        }
        prev1.next = dummy2.next;
        ListNode ret = dummy1.next;
        return ret;
    }
}
