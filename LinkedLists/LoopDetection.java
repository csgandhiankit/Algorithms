import java.util.*;
import java.io.*;


public class LoopDetection{

	static class Node{
		Node next = null;
		int data;
		boolean visited;
		public Node(int data){
			this.data = data;
			visited = false;
		}


		public void appendToTail(int data){
			Node tail = new Node(data);

			Node head = this;

			while(head.next != null){
				head = head.next;
			}
			head.next = tail;
		}
	}

	public static void main(String[] args) {
		int[] testCases = {2, 3, 4, 5, 6, 7, 8, 9, 10, 3};

		Node head = new Node(1);

		for(int i : testCases){
			head.appendToTail(i);
		}
		HashSet<Integer> set = new HashSet<>();


		while(head != null){
			if(!set.contains(head.data)) set.add(head.data);
			else{
				System.out.println("Loop Exists, head of circular list: " + head.data);
				break;
			} 
			head = head.next;
		}
	}
}