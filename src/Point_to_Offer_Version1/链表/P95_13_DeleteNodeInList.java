package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.ListNode;

public class P95_13_DeleteNodeInList
{
    /*
    * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

    返回删除后的链表的头节点。
    */
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void main(String[] args){
        ListNode f = new ListNode(4);
        f.next = new ListNode(5);
        f.next.next = new ListNode(6);
        System.out.println(deleteNode(f, 6).val);
    }
}
