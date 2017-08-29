package leetcode;

import java.util.Stack;

/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);
//        ListNode node8 = new ListNode(8);
//        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

//        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        System.out.println(main.sortedListToBST(node1).val);
        ListNode iter = main.addTwoNumbers(node1, node5);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode lowBit = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty())
                sum += s1.pop();
            if (!s2.empty())
                sum += s2.pop();
            lowBit.val = sum % 10;
            ListNode highBit = new ListNode(sum / 10);
            highBit.next = lowBit;
            lowBit = highBit;
            //每运算一次左移一位
            sum /= 10;
        }
        return lowBit.val == 0 ? lowBit.next : lowBit;
    }
}