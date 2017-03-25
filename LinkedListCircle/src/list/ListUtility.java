package list;

public class ListUtility {
	private Node tail;

	// 构造链表
	Node createList(int nodeNum) {
		if (nodeNum <= 0) {
			return null;
		}

		Node head = null;
		int val = 0;
		Node node = null;

		while (nodeNum > 0) {

			if (head == null) {
				head = new Node();
				head.val = val;
				node = head;
				tail = head;

			} else {
				node.next = new Node();
				node = node.next;
				node.val = val;
				node.next = null;
				tail = node;
			}

			val++;
			nodeNum--;
		}

		return head;
	}

	public Node createCycleList(int totalNodeNum, int circleNodeNum) {
		// 条件不符合
		if (totalNodeNum < circleNodeNum) {
			return null;
		}

		Node head = createList(totalNodeNum);
		Node temp = head;
		int stepCount = totalNodeNum - circleNodeNum;

		while (stepCount > 0) {
			temp = temp.next;
			stepCount--;
		}
		// 尾指针指向环的开始，构造链表环
		tail.next = temp;

		return head;
	}

	// 打印链表
	public void printList(Node head) {
		while (head != null && head.visited == false) {
			System.out.print(head.val + " -> ");
			head.visited = true;
			head = head.next;
		}

		System.out.println("null");
	}
}
