import java.util.*;
import java.io.*;

public class MergeSort{


	public static void sort(int[] arr){
		sort(arr, new int[arr.length], 0, arr.length-1);
	}

	public static void sort(int[] arr, int[] temp,  int start, int end){
		if(start >= end) return;
		int mid = (start + end) / 2;
		sort(arr, temp, start, mid);
		sort(arr, temp, mid + 1, end);
		mergeHalves(arr, temp, start, end);	
	}

	public static void mergeHalves(int[] arr, int[] temp,  int start, int end){
		int leftEnd = (end + start) / 2;
		int rightStart = leftEnd + 1;
		int size = (end - start) + 1;

		int left = start;
		int right = rightStart;
		int index = start;


		while(left <= leftEnd && right <= end){
			if(arr[left] <= arr[right]){
				temp[index] = arr[left];
				left++;
			}else{
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
 
		System.arraycopy(arr, left, temp, index, leftEnd - left + 1); //(source, startingIdx, dest, startingPointDest, size)
		System.arraycopy(arr, right, temp, index, end - right + 1);
		System.arraycopy(temp, start, arr, start, size);

	}


	public static void printArr(int[] arr, String label){
		System.out.print(label + ": ");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}



	public static void main(String[] args) {
		int[] testCase = {33, 24, 3, 4, 43, 16, 27, 37,42, 72, 84, 9, 211, 10};
		printArr(testCase, "Before Sorting");
		long t0 = System.nanoTime();
		sort(testCase);
		long t1 = System.nanoTime();
		printArr(testCase, "After Sorting ");

		System.out.println("Time taken: " + ((t1-t0)/1000000) + " ms");
	}
}