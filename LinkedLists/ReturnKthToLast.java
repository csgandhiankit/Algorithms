public class ReturnKthToLast{

	// trivial approach
	public static int returnKth(LinkedList list, int kth, int size)
	{
		if(kth > size) return  -1;

		if(list.head == null) return -1;


		Node current = list.head;


		int count = 0;

		while(count + kth < size)
		{
			current = current.next;
			count++;
		}

		return current.data;
		
	}

	// Recursive approach 
	public static int printKthToLast(Node head, int k) {
		if (head == null) {
			return 0;
		}

		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		return index;
	}


	//approach c: wrapper class O(n) space complexity
	public static class Index {
		public int value = 0;
	}	
	
	public static Node kthToLast(Node head, int k) {
		Index idx = new Index();
		return kthToLast(head, k, idx);
	}
	
	public static Node kthToLast(Node head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		Node node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		} 
		return node;
	}	

	//Iteratove approach with 2 pointers
	//p2 			p1
	// 1 -- > 2 --> 3 --> 4
	public static Node getKthToLast(Node head, int k)
	{
		Node p1 = head; 
		Node p2 = head;

		for(int i =0; i < k; i++)
		{
			if(p1 == null) return null; // out of bounds
			p1 = p1.next;
		}
		//System.out.println("p1 after moving: " + p1.data);
		while(p1.next != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public static void main(String[] args){

		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(1);
		list.append(2); 
		list.append(6);
		list.append(7);

		//print the list
		list.printList(list);

		// System.out.println(list.getSize(list));

		// //print kth to last element in linkedlist
		// System.out.println(returnKth(list, 2g, list.getSize(list)));

		//System.out.println(printKthToLast(list.head, 3));

		//System.out.println(kthToLast(list.head, 3).data);

		System.out.println(getKthToLast(list.head, 3).data);

		



	}
}