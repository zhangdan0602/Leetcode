package leetcode_2020.tag001_stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zd on 2020/2/10.
 */
public class code027_BinaryTreeInorderTraversal {
    public static void helper(TreeNode root, List<Integer> res){
        if (root != null){
            if (root.left != null){
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null)
                helper(root.right, res);
        }
    }
    public static List< Integer > inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    // stack
    public static List< Integer > inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
    public static List< Integer > inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null)
            return res;
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            res.add(node.val);
            if (node.right != null){
                stack.add(node.right);
            }
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return res;
    }
    public static void main(String args[]){
        System.out.println(inorderTraversal(new TreeNode(1)));
    }
}
