package Point_to_Offer_Version1.树;

import Point_to_Offer_Version1.TreeNode;

public class P117_18_SubstructureInTree
{
    /*
    * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null){
            if (A.value == B.value){
                result = DoesTree1HaveTree2(A, B);
            }
            if (!result){
                result = isSubStructure(A.left, B);
            }
            if (!result)
                result = isSubStructure(A.right, B);
        }
        return result;
    }

    private boolean DoesTree1HaveTree2(TreeNode a, TreeNode b)
    {
        if (b == null)
            return true;
        if (a == null)
            return false;
        if (a.value != b.value)
            return false;
        return DoesTree1HaveTree2(a.left, b.left) && DoesTree1HaveTree2(a.right, b.right);
    }

}
