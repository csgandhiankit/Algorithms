public class Node{
	Node next;
	int data;

	public Node(int data)
	{
		this.data = data;
	}

	
}

public class LinkedList{

	Node head;

	public void append(int data)
	{
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = new Node(data);
	}

	public void prepend(int data){
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
 	}

 	pubilc void deleteWithValue(int data)
 	{
 		if(head == null) return;
 		if(head.data == data)
 		{
 			head = head.next;
 			return;
 		}

  		
  		Node current = head;
  		while(current.next != null)
  		{
  			if(current.next.data == data)
  			{
  				current.next = current.next.next;
  				return; 
  			}
  			current = current.next;
  		}
 	}

 	/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
   HashSet<Node> set = new HashSet<Node>();
    if(head == null)
        {
        return false;
    }
    Node current = head;
    while(current.next != null)
        {
        if(set.contains(current))
            {
            return true;
        }
        else
            {
            set.add(current);
            current = current.next;
        }
        
    }
    return false;
    

}



}