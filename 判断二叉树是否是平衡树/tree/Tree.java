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


        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node3.setRightChild(node6);
        node2.setRightChild(node5);
        node2.setLeftChild(node4);
        node5.setLeftChild(node7);
        System.out.println(new Tree().isBalanceed(node1));
    }


    public boolean isBalanceed(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftDeep = TreeDeep(node.getLeftChild());
        int rightDeep = TreeDeep(node.getRightChild());
        return Math.abs(leftDeep - rightDeep) > 1 ? false : isBalanceed(node.getLeftChild()) && isBalanceed(node.getRightChild());
    }


    public int TreeDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDeep = TreeDeep(node.getLeftChild());
        int rightDeep = TreeDeep(node.getRightChild());
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }
}
