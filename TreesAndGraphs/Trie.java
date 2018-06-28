import java.io.*;
import java.util.*;

public class Trie{

	public static class Node{

	private static int NUMBER_OF_CHARACTER = 26;
	Node[] children = new Node[NUMBER_OF_CHARACTER];

	int size = 0; //to keep track of numbe of children of each node

	private static int getCharIndex(char c){
		return c - 'a';
	}

	private Node getNode(char c){
		return children[getCharIndex(c)];
	}

	private void setNode(char c, Node node){
		children[getCharIndex(c)] = node;
	}


	public void add(String s){
		add(s, 0);
	}

	public void add(String s, int index){
		size++;
		if(index == s.length()) return;
		char current = s.charAt(index);

		Node child = getNode(current);
		if(child == null)
		{
			child = new Node();
			setNode(current, child);
		}
		child.add(s, index+1);
	}

	public int findCount(String s, int index){
		if(index == s.length()) return size;
		Node child = getNode(s.charAt(index));
		if(child == null) return 0;
		return child.findCount(s, index +1);
		}

	}

	public static void main(String[] args)
	{
		Node node  = new Node();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i = 0; i < n; i++)
		{
			String op = in.next();
			String contact = in.next();
			if(op.equals("add"))
			{
				node.add(contact);
			}
			else if(op.equals("find")){
				int count =	node.findCount(contact, 0);
				System.out.println(count);
			}
			else{
				System.out.println("Not a valid operation");
			}
		}




	}
}