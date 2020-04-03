package leetcode_2020;

/*
* https://leetcode-cn.com/problems/validate-binary-search-tree/
*
*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
*/
public class code098_validBST
{
    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max)
    {
        if (root == null)
            return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
