package leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
//        ListNode node7 = new ListNode(7);
//        ListNode node8 = new ListNode(8);
//        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        System.out.println(main.sortedListToBST(node1).val);
        ListNode iter = main.partition(node1, 3);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;

        ListNode smaller_sentinel = new ListNode(0);
        ListNode smaller_cur = smaller_sentinel;
        ListNode larger_sentinel = new ListNode(0);
        ListNode larger_cur = larger_sentinel;
        //Now, go along the list, partitioning into two halves.
        while (cur != null) {
            if (cur.val < x) {
                smaller_cur.next = cur;
                smaller_cur = smaller_cur.next;

            } else {
                larger_cur.next = cur;
                larger_cur = larger_cur.next;
            }
            cur = cur.next;
        }
        //Now, do the concatenation of two havles. Make sure the last node points to null
        larger_cur.next = null;
        smaller_cur.next = larger_sentinel.next;
        return smaller_sentinel.next;
    }
}