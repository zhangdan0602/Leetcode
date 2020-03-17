package Point_to_Offer_Version1.树;

public class P140_24_SequenceOfBST
{
    /*
    * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
    */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    public boolean recur(int[] postorder, int i, int j){
        if (i >= j)
            return true;
        int l = i;
        while (postorder[l] < postorder[j]){
            l++;
        }
        int m = l;
        while (postorder[l] > postorder[j]){
            l++;
        }
        return l == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args){
        P140_24_SequenceOfBST sequenceOfBST = new P140_24_SequenceOfBST();
        System.out.println(sequenceOfBST.verifyPostorder(new int[]{7,4,6,5}));
    }
}
