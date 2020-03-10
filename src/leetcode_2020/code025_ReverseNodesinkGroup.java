package leetcode_2020;

public class code025_ReverseNodesinkGroup
{
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pointer = dummyHead;
        while (pointer != null){
            ListNode lastGroup = pointer;
            int i = 0;
            for (; i < k; i++)
            {
                pointer = pointer.next;
                if (pointer == null)
                    break;
            }
            if (i == k){
                ListNode nextGroup = pointer.next;
                ListNode reversedList = reverse(lastGroup.next, nextGroup);
                pointer = lastGroup.next;
                lastGroup.next = reversedList;
                pointer.next = nextGroup;
            }
        }
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode tail)
    {
        if (head == null || head.next == null)
            return null;
        ListNode prev = null, temp = null;
        while (head != null && head != tail){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

