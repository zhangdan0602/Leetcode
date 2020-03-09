package leetcode_2020.tag001_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zd on 2020/2/10.
 */
public class code031_SymmetricTree {
    public boolean ismirror(TreeNode n1, TreeNode n2){
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;
        return n1.val == n2.val && ismirror(n1.right, n2.left) && ismirror(n1.left, n2.right);
    }
    public boolean isSymmetric(TreeNode root) {
        return ismirror(root, root);
    }
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null || n2 == null)
                return false;
            if (n1.val != n2.val)
                return false;
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }
}
