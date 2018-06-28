import java.util.*;
import java.io.*;

public class SortNearlySorted{

	//Sort a nearly sorted array in O(nlogk) time and O(k) auxillary space

	public static void sort(int[] arr, int k){
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>();
		for(int i = 0; i <= k; i++){
			lowers.add(arr[i]);
		}
		int index = 0;

		for(int i = k + 1; i < arr.length; i++){
			arr[index++] = lowers.poll();
			lowers.add(arr[i]);
		}
		
		while(!lowers.isEmpty()){
			arr[index++] = lowers.poll();
			
		}

	}


	public static void printArr(int[] arr, String label){
		System.out.print(label + ": ");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		int[] testCase = {2, 6, 3, 12, 56, 8};
		int[] testCase2 = { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
		printArr(testCase2, "Before Sorting");
		int k = 2;
		long t0 = System.nanoTime();
		sort(testCase2, k);
		long t1 = System.nanoTime();
		printArr(testCase2, "After Sorting ");

		System.out.println("Time taken: " + ((t1-t0)/1000000) + " ms");
	}
}