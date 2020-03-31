package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.ListNode;

public class P107_15_KthNodeFromEnd
{
    /*
    * 输入一个链表，输出该链表中倒数第k个节点。
    * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
    例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
    */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode first = head, second = head;
        for (int i = 0; i < k - 1; i++)
        {
            if (first.next != null){
                first = first.next;
            }else
                return null;
        }
        while (first.next != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        System.out.println(getKthFromEnd(head, 4).val);
    }
}
