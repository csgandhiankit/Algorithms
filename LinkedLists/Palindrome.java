import java.io.*;
import java.util.*;

public class Palindrome{

	public static boolean isListPalindrome(LinkedListChar list){
		//return false if list is empty, although an empty string is considered a palindrome
		//for sake of simplicity null string is false in this case;
		if(list.head == null) return false;

		// in case list only has a single character
		if(list.head.next == null) return true;

		// else all other cases 
		Stack<Character> s = new Stack<Character>();
		NodeChar p1 = list.head;
		NodeChar p2 = list.head;

		while(p2 != null && p2.next != null )
		{	
			s.push(p1.data);
			p2 = p2.next.next;
			p1 = p1.next;
			
		}

	
		//System.out.println(p1.data);

		if(p2 != null) //odd number
		{
			p1 = p1.next;
		}

		while(p1.next != null)
		{
			if(s.peek() != p1.data)
			{
				return false;
			}
			s.pop();
			p1 = p1.next;
		}


		return true; 

	}


	public static void main(String[] args){

		LinkedListChar list = new LinkedListChar();
		list.append('m');
		list.append('a');
		list.append('d');
		list.append('a');
		list.append('m');

		LinkedListChar list1 = new LinkedListChar();
		list1.append('p');
		list1.append('u');
		list1.append('l');
		list1.append('l');
		list1.append('u');
		list1.append('p');


		LinkedListChar list2 = new LinkedListChar();
		list2.append('t');
		list2.append('a');
		list2.append('c');
		list2.append('o');
		list2.append('c');
		list2.append('a');
		list2.append('t');


		LinkedListChar list3 = new LinkedListChar();
		list3.append('n');
		list3.append('o');
		list3.append('o');
		list3.append('n');
		
		//non-palindrome
		LinkedListChar list4 = new LinkedListChar();
		list4.append('r');
		list4.append('a');
		list4.append('o');
		list4.append('n');

		LinkedListChar list5 = new LinkedListChar();
		list5.append('r');
		list5.append('a');
		list5.append('r');


		

		list.printList(list);
		System.out.println("Expected: true" + " Actual: " +  isListPalindrome(list));

		list1.printList(list1);
		System.out.println("Expected: true" + " Actual: " +  isListPalindrome(list1));

		list2.printList(list2);
		System.out.println("Expected: true" + " Actual: " +  isListPalindrome(list2));

		list3.printList(list3);
		System.out.println("Expected: true" + " Actual: " +  isListPalindrome(list3));

		list4.printList(list4);
		System.out.println("Expected: false" + " Actual: " +  isListPalindrome(list4));

		list5.printList(list5);
		System.out.println("Expected: true" + " Actual: " +  isListPalindrome(list5));

		
	}
}