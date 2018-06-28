import java.util.*;
import java.io.*;

public class MergeLists{

	static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
		}
	}


	//recursive solution
	public static Node mergeLists(Node l1, Node l2){

		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.data < l2.data){
			l1.next = mergeLists(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeLists(l2.next, l1);
			return l2;
		}
	}

	//iterative solution ** important => value of reference variable (p) doesnt change
	public static Node mergeListsIter(Node l1, Node l2){
		Node head = new Node(0);
		Node p = head;

		while(l1 != null || l2 != null){
			if(l1 != null && l2 != null){
				if(l1.data < l2.data){
					head.next = l1;
					l1 = l1.next;
				} else{
					head.next = l2;
					l2 = l2.next;
				}
			}
			else if(l1 == null){
				head.next = l2;
				l2 = l2.next;
			}else if(l2 == null){
				head.next = l1;
				l1 = l1.next;
			}
			head = head.next;
		}
		return p.next;

	}


	public static void addNode(Node head, int data){

		Node current = head;
		while(current.next != null){
			current = current.next;

		}
		current.next = new Node(data);
	}

	public static void main(String[] args) {
			
			int[] a1 = {3, 5, 6};
			int[] a2 = {4, 7};


			Node l1 = new Node(1);
				
			for(int i : a1){
				addNode(l1, i);
			}

			Node l2 = new Node(2);

			for(int i : a2){
				addNode(l2, i);
			}

			Node merged = mergeListsIter(l1, l2);

			while(merged.next != null){
				System.out.print(merged.data + " ");
				merged = merged.next;
			}
			System.out.println(merged.data);


	}
}