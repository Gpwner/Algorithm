package leetcode;

/**
 * @version 2017/8/23.22:07
 * <p>
 * <p>
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        main.reorderList(node1);
        ListNode iter = node1;
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        //divide into two list,
        // 如果单链表的节点的个数为奇数的话，那么第一个链表的节点个数比第二个节点的个数多一个中间节点
        //比如0->1->2->3->4,那么第一个链表的节点：0->1->2
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;
        //reverse second list
        ListNode cur = fast, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        fast = pre;
        //merge
        while (fast != null) {
            ListNode t1 = slow.next, t2 = fast.next;
            slow.next = fast;
            fast.next = t1;
            slow = t1;
            fast = t2;
        }
        return;
    }

}