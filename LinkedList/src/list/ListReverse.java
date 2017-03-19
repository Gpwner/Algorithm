package list;

public class ListReverse {
	private Node head;
	private Node newHead;

	public ListReverse(Node head) {
		this.head = head;
	}

	// ����ݹ鵹ת
	private Node recursiveReverse(Node node) {
		//�������Ϊ��||���ߵ�ǰ�ӵ��������β���
		if (node == null || node.next == null) {
			newHead = node;
			return node;
		}
		//ָ�뷴ָ
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
