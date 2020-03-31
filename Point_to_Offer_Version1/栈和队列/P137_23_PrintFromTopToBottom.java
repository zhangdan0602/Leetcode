package Point_to_Offer_Version1.栈和队列;

import Point_to_Offer_Version1.TreeNode;

import java.util.*;

public class P137_23_PrintFromTopToBottom
{
    /*
    *从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    */
    // BFS
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.value);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
    /*
    *从上到下打印出二叉树的每个节点。
    */
    // DFS
    List<Integer> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<Integer> inner(TreeNode root){
        queue.add(root);
        TreeNode node = queue.poll();
        list.add(node.value);
        if (node.left != null){
            inner(node.left);
        }
        if (root.right != null){
            inner(node.right);
        }

        return list;
    }
    public static void main(String[] args){
        P137_23_PrintFromTopToBottom print = new P137_23_PrintFromTopToBottom();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(5);
        int[] result =print.levelOrder(node);
        for (int x: result)
        {
            System.out.println(x);
        }
        List<Integer> list = print.inner(node);
        System.out.println(list);
    }
}
