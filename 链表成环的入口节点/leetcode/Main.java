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
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node4;

//        ListNode iter = node1;
//        while (iter != null) {
//            System.out.print(iter.val + " ");
//            iter = iter.next;
//        }
        System.out.println("链表的成环的入口节点是：" + main.detectCycle(node1).val);
    }

    /**
     * 如果fast和slow相遇，那么在相遇时，slow肯定没有遍历完链表，而fast已经在环内循环了n圈（n>=1）（见下面的证明2）。假设 slow走了s步，则fast走了2s步（fast的步数还等于s加上在环上多转的n圈），设环长为r，则：
     * 2s=s+nr
     * s=nr
     * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a，则
     * a+x=s=nr
     * a+x=(n-1)r+r=(n-1)r+L-a
     * a=(n-1)r+(L-a-x)
     * (L-a-x)为相遇点到环入口点的距离。由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点。于是可以从链表头和相遇点分别设一个 指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
     */

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //找到两个指针相遇的节点
            if (fast == slow) {
                System.out.println("相遇的节点是：" + fast.val);
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}