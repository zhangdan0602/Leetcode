package Point_to_Offer_Version1;

public class Node
{
    public int val;
    public Node next;
    public Node random;

    public Node left;
    public Node right;


    public Node() {}


    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int val) {
        this.val = val;
    }
}
