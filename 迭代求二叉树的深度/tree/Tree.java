package tree;

/**
 * @version 2017/6/25.10:06
 */
public class Tree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);


        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node3.setRightChild(node6);
        node2.setRightChild(node5);
        node2.setLeftChild(node4);
        node5.setLeftChild(node7);
        System.out.println(new Tree().TreeDeep(node1));
    }

    public int TreeDeep(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDeep = TreeDeep(node.getLeftChild());
        int rightDeep = TreeDeep(node.getRightChild());
        return leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
    }
}
