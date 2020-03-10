package leetcode_2020;

/**
 * Created by Zd on 2020/2/10.
 */
public class code031_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.right, q.right)&& isSameTree(p.left, q.left);
    }
}
