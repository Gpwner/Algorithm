package leetcode;

/**
 * @author 东北大学软件工程 许正创
 * @version 2017/8/23.22:07
 */
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
        ListNode node10 = new ListNode(10);

        node1.next = node3;
        node2.next = node4;
        node3.next = node5;
        node4.next = node6;
        node5.next = node7;
        node6.next = node8;
        node7.next = node9;
        node8.next = node10;
        ListNode node = main.mergeTwoLists(node1, node2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null)
//            return null;
//        if (l1 == null)
//            return l2;
//        if (l2 == null)
//            return l1;
//        ListNode preHead = new ListNode(-1);
//        ListNode iter = preHead;
//
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                iter.next = l1;
//                l1 = l1.next;
//            } else {
//                iter.next = l2;
//                l2 = l2.next;
//            }
//            iter = iter.next;
//        }
//
//
//
//        if (l1 == null) {
//            iter.next = l2;
//        } else if (l2 == null) {
//            iter.next = l1;
//        }
//        return preHead.next;
//    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}