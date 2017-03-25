package list;

public class LinkedList {
	 public static void main(String[] args) {
	        ListUtility util = new ListUtility();
	        Node head = util.createList(10);
	        util.printList(head);

	        ListReverse reverse = new ListReverse(head);
	        util.printList(reverse.getReverseList());
	    }
}
