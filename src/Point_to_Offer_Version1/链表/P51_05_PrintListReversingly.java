package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.ListNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P51_05_PrintListReversingly
{
    /*
    * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
    */
    public static int[] PrintListReversingly_Iteratively(ListNode head){
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        // 这里声明，否则pop后，size是越来越小的。
        int size = stack.size();
        int[] list = new int[size];
        for (int i = 0; i < size; i++)
        {
            list[i] = stack.pop().val;
        }
        return list;
    }

    public static List<Integer> PrintListReversingly_Iteratively1(ListNode head){
        List<Integer> list = new ArrayList<>();
        if (head == null)
            return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }
    // list动态增加
    public static List<Integer> PrintListReversingly_Recursively(ListNode head){
        List<Integer> list = new ArrayList<>();
        if (head == null)
            return null;
        if (head != null){
            getNext(head, list);
        }
        return list;
    }
    public static List<Integer> getNext(ListNode head, List<Integer> list){
        if (head != null){
            getNext(head.next, list);
            list.add(head.val);
        }
        return list;
    }

    // list动态增加
    public static List<Integer> rs = new ArrayList<>();
    public static List<Integer> PrintListReversingly_Recursively1(ListNode head){
        if (head == null)
            return null;
        if (head != null){
            if (head.next != null)
            {
                PrintListReversingly_Recursively1(head.next);
            }
            rs.add(head.val);
        }
        return rs;
    }



    public static void main(String[] args){
        ListNode head = new ListNode(4);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        System.out.println(PrintListReversingly_Iteratively(head));
        System.out.println(PrintListReversingly_Recursively(head));
        System.out.println(PrintListReversingly_Recursively1(head));
    }
}
