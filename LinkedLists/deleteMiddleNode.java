public class deleteMiddleNode{

	public static boolean deleteMiddle(Node head)
	{	

		if(head == null) return false;
		Node p1 = head;
		Node p2 = head.next.next;
		Node temp = head;
		while(p2.next != null){
			p2 = p2.next;
			if(p2.next == null){
			temp.next = p1.next;
			}
			else
			{
				temp = p1;
				p1 = p1.next;
			}
		}
		return true;

	}

	public static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		} 
		Node next = n.next; 
		n.data = next.data; 
		n.next = next.next; 
		return true;
	}




	public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5); 
		list.append(6);
		list.append(7);
		list.append(8);
		list.append(9);

		//print the list
		System.out.println("Before deletion");
		list.printList(list);

		deleteMiddle(list.head);
		//deleteNode(list.head.next.next.next);

		System.out.println("After deletion");
		list.printList(list);

	}
}