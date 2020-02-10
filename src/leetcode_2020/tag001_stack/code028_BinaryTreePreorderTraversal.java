package leetcode_2020.tag001_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zd on 2020/2/10.
 */
public class code028_BinaryTreePreorderTraversal {

    public void helper(TreeNode root, List<Integer> res){
        if (root != null){
            res.add(root.val);
            if (root.left != null)
                helper(root.left, res);
            if (root.right != null){
                helper(root.right, res);
            }
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

}