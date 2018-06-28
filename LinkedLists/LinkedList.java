
import java.util.*;
import java.io.*;

class Node{

	 int  data;
	 Node next;

	public Node(int data){
		this.data = data;
		this.next = null;
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

	public int getSize(LinkedList list)
	{
		int size = 0;
		Node current = list.head;
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



	public  void printList(LinkedList list)
	{
		Node temp = list.head;
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
		//ArrayList<boolean> table = new ArrayList<boolean>();
		Set<Integer> set = new HashSet<Integer>();
		LinkedList list = new LinkedList();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(1);
		list.append(2);
		list.append(6);

		//remove duplicates
		Node current = list.head;
		Node previous = null;
		while(current.next != null)
		{
			if(set.contains(current.data)){
				previous.next = current.next.next;
			}
			else{
				set.add(current.data);			
			}
			previous = current;
			current = current.next;
			 
		}

		Node temp = list.head;
		while(temp.next != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
			if(temp.next == null)
			{
				System.out.println(temp.data);
			}
		}

		//System.out.println(temp.data);
	}
}



