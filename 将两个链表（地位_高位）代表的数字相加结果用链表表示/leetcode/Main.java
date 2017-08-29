package leetcode;

/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
//        ListNode node8 = new ListNode(8);
//        ListNode node9 = new ListNode(9);
//        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
        ListNode iter = main.addTwoNumbers(node2, node5);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            ListNode cur = new ListNode(0);
            sum += ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val);
            cur.val = sum % 10;
            sum = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}