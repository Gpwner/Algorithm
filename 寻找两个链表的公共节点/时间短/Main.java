import javax.swing.*;
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
        if (headA == null || headB == null)
            return null;
        int lenA = getLinkedListLenght(headA);
        int lenB = getLinkedListLenght(headB);
        int gap = lenA - lenB;
        if (gap >= 0) {
            ListNode nodeA = headA;
            for (int i = 0; i < gap; i++) {
                nodeA = nodeA.next;
            }
            return getFistSameNode(nodeA, headB);
        } else if (gap < 0) {
            ListNode nodeB = headB;
            for (int i = 0; i < -gap; i++) {
                nodeB = nodeB.next;
            }
            return getFistSameNode(headA, nodeB);
        }
        return null;
    }

    public int getLinkedListLenght(ListNode head) {
        int len = 0;
        ListNode pointer = head;
        while (pointer != null) {
            len++;
            pointer = pointer.next;
        }
        return len;
    }

    public ListNode getFistSameNode(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
