package leetcode;

/*
* Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass
* */
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
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
        ListNode iter = main.removeNthFromEnd(node1, 2);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head, node2 = head;
        while (n-- > 0) {
            node2 = node2.next;
        }
        if (node2 == null)
            return head.next;
        node2 = node2.next;
        while (node2 != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        node1.next = node1.next.next;
        return head;
    }

}