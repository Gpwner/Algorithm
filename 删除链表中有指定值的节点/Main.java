package leetcode;

/**
 * @version 2017/7/29.21:17
 */
public class Main {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = node1;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("\n===================================================");
        node = new Main().removeElements(node1, 6);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val)
                //将目标节点删除
                pointer.next = pointer.next.next;
            else
                pointer = pointer.next;
        }
        //对头结点进行处理
        return head.val == val ? head.next : head;
    }
}
