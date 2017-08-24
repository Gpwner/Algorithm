package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author 东北大学软件工程 许正创
 * @version 2017/8/23.22:07
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(1);
        ListNode node10 = new ListNode(10);

        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node8;
        node7.next = node9;
        node8.next = node10;
        ListNode node = main.deleteDuplicates(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    //    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode res = new ListNode(0);
//        res.next = head;
//        ListNode iter = res.next;
//        while (iter.next != null) {
//            if (iter.next.val == iter.val) {
//                while (iter.next.next != null && iter.next.val == iter.val) {
//                    iter.next = iter.next.next;
//                }
//                if (iter.next.next == null && iter.next.val == iter.val) {
//                    iter.next = null;
//                    return res.next;
//                }
//                if (iter.next.next == null && iter.next.val != iter.val) {
//                    iter.next = iter.next;
//                    return res.next;
//                }
//                iter.next = iter.next;
//            }
//            iter = iter.next;
//        }
//        return res.next;
//    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode mark = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);
        while (head.next != null) {
            if (!set.contains(head.next.val)) {
                set.add(head.next.val);
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return mark;
    }

}