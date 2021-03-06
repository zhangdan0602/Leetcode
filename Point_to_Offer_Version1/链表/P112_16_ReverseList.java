package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.ListNode;

public class P112_16_ReverseList
{
    /*
    * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
    */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null){
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }
        return prev;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        System.out.println(reverseList(head).val);
    }
}
