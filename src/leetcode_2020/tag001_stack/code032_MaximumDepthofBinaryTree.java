package leetcode_2020.tag001_stack;

/**
 * Created by Zd on 2020/2/10.
 */
public class code032_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
