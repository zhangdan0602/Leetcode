package leetcode_2020;

import Point_to_Offer_Version1.ListNode;

public class code160_FirstCommonNodesInLists
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode head1 = headA, head2 = headB;
        while (head1 != head2){
            head1 = head1 == null ? headB: head1.next;
            head2 = head2 == null ? headA: head2.next;
        }
        return head1;
    }

    public static void main(String[] args)
    {
        code160_FirstCommonNodesInLists firstCommonNodesInLists = new code160_FirstCommonNodesInLists();
        ListNode headA = new ListNode(3);
        headA.next = new ListNode(4);
        ListNode headB = new ListNode(2);
        headB.next = new ListNode(4);
        System.out.println(firstCommonNodesInLists.getIntersectionNode(headA, headB));
    }
}
