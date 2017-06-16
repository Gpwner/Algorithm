package linkedlistProble;

import java.util.*;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        /**
         *
         * 1->2->3
         *          ->6->7
         *    4->5
         *
         */
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        //方法一使用栈：
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        java.util.LinkedList<Node> linkedList1 = new LinkedList<>();
        java.util.LinkedList<Node> linkedList2 = new LinkedList<>();
        linkedList1.add(node1);
        linkedList1.add(node2);
        linkedList1.add(node3);
        linkedList1.add(node6);
        linkedList1.add(node7);
        linkedList2.add(node4);
        linkedList2.add(node5);
        linkedList2.add(node6);
        linkedList2.add(node7);
        Iterator<Node> it = linkedList1.iterator();
        while (it.hasNext()) {
            stack1.add(it.next());
        }
        Iterator<Node> it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            stack2.add(it2.next());
        }
        Node sameNode = null;
        while (!stack2.isEmpty() && !stack1.isEmpty()) {
            Node temp1 = stack1.pop();
            Node temp2 = stack2.pop();
            if (temp2 != temp1) {
                break;
            }
            sameNode = temp1;
        }
        System.out.println("相同的节点是：" + sameNode.getData());

        //第二种方法
        int index = linkedList1.size() - linkedList2.size();

        Iterator<Node> iterator1 = linkedList1.iterator();
        Iterator<Node> iterator2 = linkedList2.iterator();
        //第一个链表比第二个链表长
        if (index > 0) {
            while (index != 0) {
                iterator1.next();
                index--;
            }
            //第一个链表比第二个链表短
        } else if (index < 0) {
            while (index != 0) {
                iterator2.next();
                index++;
            }
        }
        Node nodeSamesecond = null;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Node temp1 = iterator1.next();
            Node temp2 = iterator2.next();
            if (temp2.getData() == temp1.getData()) {
                nodeSamesecond = temp1;
                break;
            }
        }
        if (nodeSamesecond != null) {
            System.out.println("相同的节点是：" + nodeSamesecond.getData());
        }
    }
}
