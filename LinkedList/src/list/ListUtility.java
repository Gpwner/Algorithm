package list;

public class ListUtility {
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
	            } else {
	                node.next = new Node();
	                node = node.next;
	                node.val = val;
	                node.next = null;
	            }

	            val++;
	            nodeNum--;
	        }

	        return head;
	    }

	    public void printList(Node head) {
	        while (head != null) {
	            System.out.print(head.val + " -> ");
	            head = head.next;
	        }

	        System.out.println("null");
	    }
}
