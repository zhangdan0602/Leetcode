package leetcode_2020;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class code113_PathInTree
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
        current += root.val;
        path.push(root.val);
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
        code113_PathInTree pathInTree = new code113_PathInTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(pathInTree.pathSum(root, 22));
    }
}
