package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

public class P207_39_1_TreeDepth
{
    /*
    * 输入一棵二叉树的根节点，求该树的深度。
    * */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
