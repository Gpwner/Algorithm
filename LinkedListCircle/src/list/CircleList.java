package list;

public class CircleList {
	public static void main(String[] args) {
		ListUtility util = new ListUtility();
		Node head = util.createCycleList(10, 6);
		util.printList(head);
		CircleList cl = new CircleList();
		int circleLen = cl.getCircleLength(head);

		System.out.println("length of list circle is: " + circleLen);

		head = util.createList(10);
		circleLen = cl.getCircleLength(head);
		System.out.println("length of list circle is: " + circleLen);
	}

	// 两个指针
	private Node stepOne;
	private Node stepTwo;
	// 访问的节点的个数
	private int stepCount = 0;
	private int visitCount = 0;
	int lenOfFirstVisit = 0;
	int lenOfSecondVisit = 0;

	public int getCircleLength(Node head) {
		stepOne = head;
		stepTwo = head;
		lenOfFirstVisit = 0;
		lenOfSecondVisit = 0;

		do {
			if (goOneStep() == false || goTwoStep() == false) {
				break;
			}

			stepCount++;

			if (stepOne == stepTwo) {
				visitCount++;
				// 第一次相遇
				if (visitCount == 1) {
					lenOfFirstVisit = stepCount;
				}
				// 第二次相遇
				if (visitCount == 2) {
					lenOfSecondVisit = stepCount;
				}
			}
		} while (visitCount < 2);

		return lenOfSecondVisit - lenOfFirstVisit;
	}

	// 走一步
	private boolean goOneStep() {
		if (stepOne == null || stepOne.next == null) {
			return false;
		}

		stepOne = stepOne.next;
		return true;
	}

	// 走两步
	private boolean goTwoStep() {
		if (stepTwo == null || stepTwo.next == null || stepTwo.next.next == null) {
			return false;
		}

		stepTwo = stepTwo.next.next;
		return true;
	}
}
