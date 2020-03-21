package leetcode_2020;

import Point_to_Offer_Version1.TreeNode;

public class code236_LowestCommonAncestorofaBinaryTree
{
    /*
    * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    */
    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
