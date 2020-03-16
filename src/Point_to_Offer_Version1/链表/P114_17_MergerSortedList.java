package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.ListNode;

public class P114_17_MergerSortedList
{
    /*
    * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode merge = null;
        if (l1.val < l2.val){
            merge = l1;
            merge.next = mergeTwoLists(l1.next, l2);
        }else {
            merge = l2;
            merge.next = mergeTwoLists(l1, l2.next);
        }
        return merge;
    }
}
