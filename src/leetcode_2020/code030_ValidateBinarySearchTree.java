package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/10.
 */
public class code030_ValidateBinarySearchTree {
    public boolean helper(TreeNode node, Integer left, Integer right){
        if (node == null)
            return true;
        int val = node.val;
        if (left != null && val <= left) return false;
        if (right != null && val >= right) return false;
        if (!helper(node.left, left, val)) return false;
        if (!helper(node.right, val, right)) return false;
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

}
