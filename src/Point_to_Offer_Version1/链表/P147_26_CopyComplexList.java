package Point_to_Offer_Version1.链表;

import Point_to_Offer_Version1.Node;

import java.util.HashMap;
import java.util.Map;

public class P147_26_CopyComplexList
{
    /*请实现 copyRandomList 函数，复制一个复杂链表。
    */
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null){
            map.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}
