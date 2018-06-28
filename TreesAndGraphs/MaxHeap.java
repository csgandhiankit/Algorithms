import java.io.*;
import java.util.*;

public class MaxHeap{

	private int size = 0;
	private int capacity = 10;

	int[] items = new int[capacity];

	private int getLeftChildIndex(int index){ return (index * 2) + 1;}
	private int getRightChildIndex(int index){ return (index * 2) + 2;}
	private int getParentIndex(int index) { return (index -1) / 2;}

	private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size;}
	private boolean hasRightChild(int index){ return getRightChildIndex(index) < size;}
	private boolean hasParent(int index){ return getParentIndex(index) >= 0;}

	private int leftChild(int index){ return items[getLeftChildIndex(index)];}
	private int rightChild(int index){ return items[getRightChildIndex(index)];}
	private int parent(int index){ return items[getParentIndex(index)];}

	private void swap(int index1, int index2){
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
 	}

 	private void ensureCapacity(){
 		if(size == capacity)
 		{
 			items = Arrays.copyOf(items, capacity * 2);
 			capacity *= 2;
 		}
 	}

 	public int peek(){
 		if(size == 0) throw new IllegalStateException();

 		return items[0];
 	}

 	public int poll(){
 		if(size == 0) throw new IllegalStateException();

 		int item = items[0];
 		items[0] = items[size - 1];
 		size--;
 		heapifyDown();
 		return item;
 	}

 	public void add(int item){
 		ensureCapacity();
 		items[size] = item;
 		size++;
 		heapifyUp();
 	}

 	public void heapifyUp(){
 		int index = size - 1;
 		while(hasParent(index) && items[index] > parent(index)) //bubble up as long as node has parent and its value is greater than parent
 		{ 
 			swap(index, getParentIndex(index)); //swap the parent with current node
 			index = getParentIndex(index); // set the index to new index, which is parent index of old node.
 		}
 	}

 	public void heapifyDown(){
 		int index = 0;
 		
 		while(hasLeftChild(index))
 		{
 			int biggerChildIndex = getLeftChildIndex(index);
 			if(hasRightChild(index) && rightChild(index) > leftChild(index))
 			{
 				biggerChildIndex = getRightChildIndex(index);
 			}
 			if(items[index] > items[biggerChildIndex])
 			{
 				break;
 			}else{
 				swap(index, biggerChildIndex);
 				index = biggerChildIndex;
 			}
 		}

 	}

 	public int[] getItems(){
 		return items;
 	}





	public static void main(String[] args){
		MaxHeap heap = new  MaxHeap();
		 heap.add(12);
		 heap.add(4);
		 heap.add(5);
		 heap.add(3);
		 heap.add(8);
		 heap.add(7);
		 heap.add(222);
		


		int[] items = heap.getItems();

		for(int i : items)
		{
			System.out.print(i+ " ");
		}

	}
}