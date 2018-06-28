
import java.util.*;
import java.io.*;

class NodeChar{

	 char  data;
	 NodeChar next;

	public NodeChar(char data){
		this.data = data;
		this.next = null;
	}
}

public class LinkedListChar{
	 NodeChar head;

	public  void append(char data)
	{
		if(head == null){
			head = new NodeChar(data);
			return;
		}
		NodeChar current = head;
		while(current.next != null)
		{
			current = current.next;
		}
		current.next = new NodeChar(data);
	}

	public  int getSize(LinkedListChar list)
	{
		int size = 0;
		NodeChar current = list.head;
		if(current == null) return -1;
		while(current.next != null)
		{
			size++;
			current = current.next;

			//increment counter for last element
			if(current.next == null) size++;
		}

		return size;


	}



	public  void printList(LinkedListChar list)
	{
		NodeChar temp = list.head;
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




	public static void main(String[] args)
	{
		// //ArrayList<boolean> table = new ArrayList<boolean>();
		// Set<Integer> set = new HashSet<Integer>();
		// LinkedList list = new LinkedList();
		// list.append(1);
		// list.append(2);
		// list.append(3);
		// list.append(1);
		// list.append(2);
		// list.append(6);

		// NodeChar current = list.head;
		// NodeChar previous = null;
		// while(current.next != null)
		// {
		// 	if(set.contains(current.data)){
		// 		previous.next = current.next.next;
		// 	}
		// 	else{
		// 		set.add(current.data);			
		// 	}
		// 	previous = current;
		// 	current = current.next;
			 
		// }

		// NodeChar temp = list.head;
		// while(temp.next != null)
		// {
		// 	System.out.println(temp.data);
		// 	temp = temp.next;
		// 	if(temp.next == null)
		// 	{
		// 		System.out.println(temp.data);
		// 	}
		// }

		//System.out.println(temp.data);

	}
}



