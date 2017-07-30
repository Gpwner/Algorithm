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
        ListNode node = new Main().reverseBetween(node1, 2, 3);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //如果头节点为空或者m>=n,直接返回
        if (head == null || m >= n) {
            return head;
        }

        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode node = preNode;

        // 将指针移动到第M个节点的前面
        for (int i = 1; i < m; ++i) {
            node = node.next;
        }
        //翻转节点
        ListNode startNode = node.next;
        for (int i = m; i < n; ++i) {
            ListNode temp = node.next;
            node.next = startNode.next;
            startNode.next = startNode.next.next;
            node.next.next = temp;
        }
        return preNode.next;
    }
}
