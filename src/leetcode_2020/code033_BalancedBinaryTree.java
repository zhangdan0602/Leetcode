package leetcode_2020;

/**
 * Created by Zd on 2020/2/10.
 */
public class code033_BalancedBinaryTree {
    public int height(TreeNode root){
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
}
