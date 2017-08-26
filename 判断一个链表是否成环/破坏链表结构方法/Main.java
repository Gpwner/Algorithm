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

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node5;
        System.out.println(main.hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        ListNode p = head, pre = head;
        while (p != null && p.next != null) {
            if (p.next == head)
                return true;
            p = p.next;
            //将所有访问过的节点指向头结点，
            // 如果再次访问到这个结点的时候发现他的下一个节点是指向头结点的话，说明这个结点已经被访问过了，说明这个链表有环
            pre.next = head;
            pre = p;
        }
        return false;
    }
}