public class ReverseList{

	static Node head;

	static class Node{
		Node next;
		int data;
		public Node(int data){
			this.data = data;
		}

	}

	public static Node reverse(Node head) {
    if(head == null){
        return null;
    }
  	
  	Node currentNode = head;
  	Node prev = null;
  	Node nextNode = null;
  	while(currentNode!= null){
  		nextNode = currentNode.next;
  		currentNode.next = prev;
  		prev = currentNode;
  		currentNode = nextNode;

  	}  
    return head = prev;
    
	}



	public static void addNode(int data){
		if(head == null){
			head = new Node(data);
			return;
		}

		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);

	}


	public static void printList(Node node)
	{
		Node temp = node;
		while(temp.next != null)
		{
			System.out.print(temp.data + " --> ");
			temp = temp.next;
			if(temp.next == null)
			{
				System.out.print(temp.data + " ");
			}
		}
		System.out.println();
	}





	public static void main(String[] args) {
		addNode(3);
		addNode(4);
		addNode(5);
		addNode(7);
		addNode(8);

		printList(head);

		Node h = reverse(head);

		printList(h);

	}
}