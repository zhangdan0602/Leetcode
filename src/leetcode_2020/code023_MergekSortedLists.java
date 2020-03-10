package leetcode_2020;

import java.util.Comparator;
import java.util.PriorityQueue;

public class code023_MergekSortedLists
{
    public ListNode mergeKLists(ListNode[] lists) {
        //O(nklgk)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>()
        {
            public int compare(ListNode o1, ListNode o2)
            {
                return o1.val - o2.val;
            }
        });
        ListNode ret = null, cur = null;
        for (ListNode node:lists)
        {
            if (null != node)
                pq.add(node);
        }
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            if (null == ret)
                ret = cur = node;
            else
                cur = cur.next = node;
            if (null != node.next)
                pq.add(node.next);
        }
        return ret;
    }
    public static ListNode mergeKLists1(ListNode[] lists){
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        if (lists.length == 2)
            return mergeTwoLists(lists[0], lists[1]);
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++)
        {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; i < lists.length; i++, j++)
        {
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists1(l1), mergeKLists1(l2));
    }

    private static ListNode mergeTwoLists(ListNode l0, ListNode l1)
    {
        if (l0 == null)
            return l1;
        if (l1 == null)
            return l0;
        ListNode head = null;
        if (l0.val < l1.val){
            head = l0;
            head.next = mergeTwoLists(l0.next, l1);
        }else {
            head = l1;
            head.next = mergeTwoLists(l0, l1.next);
        }
        return head;
    }
}
