package leetcode_2020;

import java.util.ArrayList;
import java.util.List;

public class code102_BinaryTreeLevelOrderTraversal
{
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return levels;
        helper(root, 0);
        return levels;
    }
    public void helper(TreeNode node, int level){
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());
        levels.get(level).add(node.val);
        if (node.left != null){
            helper(node.left, level + 1);
        }
        if (node.right != null){
            helper(node.right, level + 1);
        }
    }

}
