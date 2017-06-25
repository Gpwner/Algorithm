package tree;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
        System.out.println(new Tree().minDepth(node1));
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = minDepth(root.leftChild);
        int rightDepth = minDepth(root.rightChild);
        //如果一个节点只有左节点或者右节点，那么返回左节点后者右节点；如果没有节点任意返回一个；如果左右节点都有，返回最小的；
        return Math.min(leftDepth, rightDepth) > 0 ? Math.min(leftDepth, rightDepth) + 1 : Math.max(leftDepth, rightDepth) + 1;
    }

}
