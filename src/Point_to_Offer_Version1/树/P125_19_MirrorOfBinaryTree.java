package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

public class P125_19_MirrorOfBinaryTree
{
    /*
    * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
    */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return null;
        TreeNode tempTree = root.left;
        root.left = root.right;
        root.right = tempTree;
        if (root.left != null)
            mirrorTree(root.left);
        if (root.right != null)
            mirrorTree(root.right);
        return root;
    }
}
