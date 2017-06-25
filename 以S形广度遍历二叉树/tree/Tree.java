package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * @version 2017/6/25.10:06
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        node1.leftChild = node2;
        node1.rightChild = node3;
        node3.rightChild = node6;
        node2.rightChild = node5;
        node2.leftChild = node4;
        node5.leftChild = node7;
        System.out.println(new Tree().levelOrder(node1));
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        trackback(lists, root, 1);
        return lists;
    }

    public void trackback(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > list.size()) {
            list.add(new LinkedList<>());
        }
        if (level % 2 == 0)
            list.get(level - 1).add(root.value);
        else
            list.get(level - 1).add(0, root.value);

        if (root.leftChild != null)
            trackback(list, root.leftChild, level + 1);
        if (root.rightChild != null)
            trackback(list, root.rightChild, level + 1);
    }
}
