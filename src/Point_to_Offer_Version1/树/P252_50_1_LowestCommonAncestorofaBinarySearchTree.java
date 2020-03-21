package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

public class P252_50_1_LowestCommonAncestorofaBinarySearchTree
{
    /*
    * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
    */
    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.value < root.value && q.value < root.value)
            return lowestCommonAncestor(root.left, p, q);
        else if (p.value > root.value && q.value > root.value)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (p.value < root.value && q.value < root.value)
                root = root.left;
            else if (p.value > root.value && q.value > root.value)
                root = root.right;
            else
                break;
        }
        return root;
    }
}
