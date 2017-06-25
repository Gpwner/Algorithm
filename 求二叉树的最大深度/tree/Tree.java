package tree;

/**
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
        System.out.println(new Tree().maxDepth(node1));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.leftChild) + 1, maxDepth(root.rightChild) + 1);
    }

}
