package list;

public class ListReverse {
	private Node head;
	private Node newHead;

	public ListReverse(Node head) {
		this.head = head;
	}

	// 链表递归倒转
	private Node recursiveReverse(Node node) {
		//如果链表为空||或者当前接点是链表的尾结点
		if (node == null || node.next == null) {
			newHead = node;
			return node;
		}
		//指针反指
		Node tail = recursiveReverse(node.next);
		tail.next = node;
		node.next = null;
		return node;
	}

	public Node getReverseList() {
		recursiveReverse(head);
		return newHead;
	}
}
