/**
 * @author
 * @version 2017/7/5.19:28
 */
public class Demo {
    public ListNode reverseList(ListNode currentnode) {
        //当前节点的前驱结点
        ListNode prenode = null;
        //当前节点不为空的时候就执行
        while (currentnode != null) {
            //在翻转指针之前先记录下当前节点的后继节点
            ListNode nextnode = currentnode.next;
            //当前节点的指针指向当前节点的前驱
            currentnode.next = prenode;
            //在遍历到当前节点的后继节点之前先记录下当前节点作为后继节点的前驱
            prenode = currentnode;
            currentnode = nextnode;
        }
        return prenode;
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
