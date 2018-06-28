import java.util.Arrays;
import java.io.*;

public class MinHeap{
	private int capacity = 10;
	private int size = 0;

	int[] items  = new int[capacity];

	 private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
	 private int getRightChildIndex(int parentIndex) { return 2 * parentIndex  + 2;}
	 private int getParentIndex(int childIndex) {  return (childIndex - 1) / 2; }

	 private boolean hasLeftChild(int index){ return getLeftChildIndex(index) < size; }
	 private boolean hasRightChild(int index) { return getRightChildIndex(index) < size;}
	 private boolean hasParent(int index) {  return getParentIndex(index) >= 0; }

	 private int leftChild(int index){ return items[getLeftChildIndex(index)]; }
	 private int rightChild(int index) { return items[getRightChildIndex(index)];}
	 private int parent(int index){ return items[getParentIndex(index)]; }

	 private void swap(int indexOne, int indexTwo){

	 	int temp = items[indexOne];
	 	items[indexOne] =  items[indexTwo];
	 	items[indexTwo] = temp;

	 }
	 private void ensureExtraCapacity()
	 {
	 	if(size == capacity)
	 	{
	 		items = Arrays.copyOf(items, capacity * 2);
	 		capacity *= 2;
	 	}
	 }

	 //gets the root element
	 public int peek(){
	 	if(size == 0) throw new IllegalStateException();

	 	return items[0]; //else return the root or min element
	 }

	 public int poll(){
	 	if(size == 0) throw new IllegalStateException();
	 	int item = items[0];
	 	items[0] = items[size -1]; //move last element into root position
	 	size--; //shrink the array 
	 	heapifyDown(); //bubble the root to bottom
	 	return item;
	 }

	 public void add(int item){
	 	ensureExtraCapacity();
	 	items[size] = item;
	 	size++;
	 	heapifyUp(); //bubble the new element upwards until a right spot 

	 }

	 public void heapifyUp(){
	 	int index = size - 1;
	 	while(hasParent(index) && parent(index) > items[index]){
	 		swap(getParentIndex(index), index);
	 		index = getParentIndex(index);
	 	}

	 }

	 public void heapifyDown(){
	 	int index = 0;
	 	while(hasLeftChild(index)){
	 		int smallerChildIndex = getLeftChildIndex(index);
	 		if(hasRightChild(index) && rightChild(index) < leftChild(index))
	 		{
	 			smallerChildIndex = getRightChildIndex(index);
	 		}
	 		if(items[index] < items[smallerChildIndex])
	 		{
	 			break;
	 		}else{
	 			swap(index, smallerChildIndex);
	 			index = smallerChildIndex;
	 		}
	 	}

	 }

	 public int[] getItems()
	 {
	 	return items; 
	 }

	public static void main(String[] args)
	{
		MinHeap heap = new MinHeap();
		 heap.add(12);
		 heap.add(4);
		 heap.add(5);
		 heap.add(3);
		 heap.add(8);
		 heap.add(7);
		


		int[] items = heap.getItems();

		for(int i : items)
		{
			System.out.print(i+ " ");
		}
	}
}