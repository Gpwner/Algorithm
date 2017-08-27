package leetcode;

/**
 * @author 东北大学软件工程 许正创
 * @version 2017/8/23.22:07
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(50);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(70);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(90);
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
        ListNode iter = main.insertionSortList(node1);
        while (iter != null) {
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode prehead = new ListNode(0);
        ListNode currNode = head, nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            ListNode innerIter = prehead;
            while (innerIter.next != null && innerIter.next.val < currNode.val) {
                innerIter = innerIter.next;
            }
            //将当前节点连入对应的位置
            currNode.next = innerIter.next;
            innerIter.next = currNode;
            currNode = nextNode;
        }
        return prehead.next;
    }
}