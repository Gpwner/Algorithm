/**
 * @author
 * @version 2017/7/5.19:28
 */
public class Demo {
    public ListNode reverseList(ListNode head) {
        //当前节点翻转过后必然是    其后继节点的后继节点，比如之前是1->2（当前节点是1），翻转过后变成2->1(当前节点的后继节点的后继节点是当前节点)
        if (head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode node = new Demo().reverseList(node1);
        while (node != null) {
            System.out.print(node.next == null ? node.val + "" : node.val + ",");
            node = node.next;
        }
    }
}
