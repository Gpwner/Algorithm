public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        System.out.println(main.isPalindrome(node1));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        int lenght = getLinkedListLenght(head);
        int[] elements = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            elements[i] = head.val;
            head = head.next;
        }
        for (int i = 0, j = lenght - 1; i < j; i++, j--) {
            if (i == j)
                return true;
            if (elements[i] != elements[j])
                return false;
        }
        return true;
    }

    public int getLinkedListLenght(ListNode node) {
        int lenght = 0;
        while (node != null) {
            lenght++;
            node = node.next;
        }
        return lenght;
    }
}
