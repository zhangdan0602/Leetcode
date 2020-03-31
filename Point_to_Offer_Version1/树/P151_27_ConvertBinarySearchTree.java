package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.Node;

public class P151_27_ConvertBinarySearchTree
{
    /*
    * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
    */
    Node head = null, pre = null, tail = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;

        InOrder(root);

        head.left = tail;
        tail.right = head;

        return head;
    }

    private void InOrder(Node root)
    {
        if (root == null)
            return;
        InOrder(root.left);

        if (pre == null)
            head = root;
        else
            pre.right = root;

        root.left = pre;
        pre = root;
        tail = root;

        InOrder(root.right);

        return;
    }

    private Node ConvertNode(Node root, Node tail)
    {
        Node cur = root;
        if (cur.left != null){
            ConvertNode(cur.left, tail);
        }

        cur.left = tail;
        if (tail != null){
            tail.right = cur;
        }

        tail = cur;
        if (cur.right != null){
            ConvertNode(cur.right, tail);
        }
        return tail;
    }
    public static void main(String[] args){
        P151_27_ConvertBinarySearchTree convertBinarySearchTree = new P151_27_ConvertBinarySearchTree();
        Node root = new Node(10);
        root.left = new Node(6);
        root.right = new Node(14);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.left = new Node(12);
        root.right.right = new Node(16);
        System.out.println(convertBinarySearchTree.treeToDoublyList(root));
    }
}
