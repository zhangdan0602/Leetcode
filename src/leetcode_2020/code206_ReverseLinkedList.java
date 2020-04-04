package leetcode_2020;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转一个单链表。
 */
public class code206_ReverseLinkedList
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode((2));
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        code206_ReverseLinkedList reverseLinkedList = new code206_ReverseLinkedList();
        reverseLinkedList.reverseList(head);

    }
}
