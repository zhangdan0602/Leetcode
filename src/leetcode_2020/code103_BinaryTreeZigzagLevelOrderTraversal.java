package leetcode_2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class code103_BinaryTreeZigzagLevelOrderTraversal
{

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.addLast(root);
        nodeQueue.addLast(null);
        LinkedList<Integer> levelList = new LinkedList<Integer>();
        boolean is_order_left = true;
        while (nodeQueue.size() > 0) {
            TreeNode cur = nodeQueue.pollFirst();
            if (cur != null){
                if (is_order_left){
                    levelList.addLast(cur.val);
                }else {
                    levelList.addFirst(cur.val);
                }
                if (cur.left != null){
                    nodeQueue.addLast(cur.left);
                }
                if (cur.right != null){
                    nodeQueue.addLast(cur.right);
                }
            }else {
                results.add(levelList);
                levelList = new LinkedList<Integer>();
                if (nodeQueue.size() > 0){
                    nodeQueue.addLast(null);
                }
                is_order_left = !is_order_left;
            }
        }
        return results;
    }
}
