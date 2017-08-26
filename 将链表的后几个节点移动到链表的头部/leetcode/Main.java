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
//        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
//        node10.next = node5;
//        System.out.println(main.hasCycle(node1));
        ListNode iter = main.rotateRight(node1, 2);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        ListNode copyHead = head;

        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }

        copyHead.next = head;
        //此时head记录的是最终链表的尾部节点，但是此时还没有断开
        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        copyHead = head.next;
        //从尾部出断开
        head.next = null;

        return copyHead;
    }
}