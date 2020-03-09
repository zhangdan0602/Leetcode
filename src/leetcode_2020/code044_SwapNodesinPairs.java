package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/18.
 */
public class code044_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
    public ListNode swapPairs1(ListNode head) {
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode preHead = dumpNode;
        while (head != null && head.next != null){
            ListNode first = head;
            ListNode second = head.next;

            first.next = second.next;
            second.next = first;
            preHead.next = second;

            preHead = first;
            head = first.next;
        }
        return dumpNode.next;
    }
}
