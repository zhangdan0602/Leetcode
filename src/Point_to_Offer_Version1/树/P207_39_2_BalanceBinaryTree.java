package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

public class P207_39_2_BalanceBinaryTree
{
    /*
    * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
    * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。*/
    public boolean isBalanced0(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced0(root.left)
                && isBalanced0(root.right);
    }
    /*
    * 输入一棵二叉树的根节点，求该树的深度。*/
    public int height(TreeNode root){
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }




    // 后序遍历
    public boolean isBalanced(TreeNode root, int[] depth) {
        if (root == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1], right = new int[1];
        if (isBalanced(root.left, left) && isBalanced(root.right, right)){
            int diff = left[0] - right[0];
            if (diff <= 1 && diff >= -1){
                depth[0] = (left[0] > right[0] ? left[0] : right[0]) + 1;
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    // 只遍历一次节点
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int[] depth = new int[1];
        return isBalanced(root, depth);
    }
}
