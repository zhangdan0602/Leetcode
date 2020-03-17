package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P143_25_PathInTree
{
    /*
    * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
    */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        Stack<Integer> path = new Stack<>();
        int current = 0;
        recur(root, path, current, sum);
        return res;
    }

    private void recur(TreeNode root, Stack<Integer> path, int current, int sum)
    {
        List<Integer> inner = new ArrayList<>();
        current += root.value;
        path.push(root.value);
        boolean left = root.left == null && root.right == null;
        if (current == sum && left){
            for (int x:path)
            {
                inner.add(x);
            }
            res.add(inner);
        }
        if (root.left != null){
            recur(root.left, path, current, sum);
        }
        if (root.right != null){
            recur(root.right, path, current, sum);
        }
        path.pop();
    }

    public static void main(String[] args){
        P143_25_PathInTree pathInTree = new P143_25_PathInTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(pathInTree.pathSum(root, 22));
    }
}
