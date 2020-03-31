package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class P55_06_ConstructBinaryTree
{
    /*
    * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,
    6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回根结点。
    */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null || preorder.length == 0){
            return null;
        }
        return reBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    public static TreeNode reBuildTree(int[] preoder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end){
        if (pre_end < pre_start || in_end < in_start)
            return null;
        int rootValue = preoder[pre_start];
        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = treeNode.right = null;
        if (pre_start == pre_end || in_start == in_end){
            return treeNode;
        }
        int rootInInorder = in_start;
        while (rootInInorder <= in_end && inorder[rootInInorder] != rootValue)
            rootInInorder++;
        int leftNodeNum = rootInInorder - in_start;
        treeNode.left = reBuildTree(preoder, inorder, pre_start + 1, pre_start + leftNodeNum, in_start, rootInInorder - 1);
        treeNode.right = reBuildTree(preoder, inorder,pre_start + leftNodeNum + 1, pre_end, rootInInorder + 1, in_end);
        return treeNode;
    }

    //pre
    public static List<Integer> preorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.add(root.value);
            list.addAll(preorderRecursively(root.left));
            list.addAll(preorderRecursively(root.right));
        }
        return list;
    }
    //in
    public static List<Integer> inorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.addAll(inorderRecursively(root.left));
            list.add(root.value);
            list.addAll(inorderRecursively(root.right));
        }
        return list;
    }
    //post
    public static List<Integer> postorderRecursively(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root!=null) {
            list.addAll(postorderRecursively(root.left));
            list.addAll(postorderRecursively(root.right));
            list.add(root.value);
        }
        return list;
    }

    public static void main(String[] args){
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        System.out.println(buildTree(pre, in));
        System.out.println(preorderRecursively(buildTree(pre, in)));
        System.out.println(inorderRecursively(buildTree(pre, in)));
        System.out.println(postorderRecursively(buildTree(pre, in)));
    }
}
