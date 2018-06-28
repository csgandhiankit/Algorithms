import java.io.*;
import java.util.*;

public class StackWithMin{

	private static class Node{
		private int data;
		private Node next;
		private int min;

		private Node(int data)
		{
			this.data = data;
			this.min = Integer.MIN_VALUE;
		}
	}
	private Node top;

	public boolean isEmpty(){
		return top == null;
	}

	public int peek()
	{
		return top.data;
	}

	public void push(int data)
	{
		Node node = new Node(data);
		if(top == null){
		node.min = data;
		node.next = top;
		top = node;
		}
		else{
		node.min = Math.min(top.data, data);
		node.next = top;
		top = node;
		}
	}
	public int pop(){
		int data = top.data;
		top = top.next;
		return data;
	}

	public int min(){
		return top.min;
	}


	public static void printStack(Node n){
			System.out.println("----------");
			System.out.println("| " + n.data + " Min: " + n.min + " |");
			System.out.println("----------");
	}



	public static void main(String[] args){
		StackWithMin stack = new StackWithMin();

		stack.push(5);
		stack.printStack(stack.top);
		stack.push(6);
		stack.printStack(stack.top);
		stack.push(3);
		stack.printStack(stack.top);
		stack.push(4);
		stack.printStack(stack.top);


		stack.pop();
		stack.printStack(stack.top);

		System.out.println(stack.min());




	}
}