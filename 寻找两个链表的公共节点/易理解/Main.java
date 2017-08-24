import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        ListNode tem = main.getIntersectionNode(node1, node6);
        System.out.println(tem.val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = null;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        //将A链表的节点压入栈
        ListNode point = headA;
        while (point != null) {
            stackA.add(point);
            point = point.next;
        }

        point = headB;
        while (point != null) {
            stackB.add(point);
            point = point.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                node = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }

        return node;
    }

}
