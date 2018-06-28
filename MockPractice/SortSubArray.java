import java.util.*;
import java.io.*;

public class SortSubArray{



	public static void sort(int[] arr){
		int startIdx = 0; 
		int endIdx  = 0;
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] > arr[i + 1]){
				startIdx = i;
				break;
			}
		}
		for(int i = arr.length - 1; i >= 0; i--){
			if(arr[i] < arr[i - 1]){
				endIdx = i;
				break;
			}
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = startIdx; i<= endIdx; i++){
			if(arr[i] < min){
				min = arr[i];
			}
			if(arr[i] > max){
				max = arr[i];
			}
		}

		int minIdx = 0, maxIdx = 0;
		for(int i = 0; i < startIdx; i++){
			if(min < arr[i]){
				minIdx = i;
				break;
			}
		}

		for(int i = endIdx; i < arr.length; i++){
			if(max < arr[i]){
				maxIdx = i - 1;
				break;
			}
		}
		System.out.println("MinIDx : " + minIdx + " maxIdx : " + maxIdx);

	}



	public static void printArr(int[] arr, String label){
		System.out.print(label + ": ");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}



	public static void main(String[] args) {
		int[] testCase = {1, 4, 7, 3, 10, 48, 17, 26, 30, 45, 50, 62};

		printArr(testCase, "Before Sorting");
		long t0 = System.nanoTime();
		sort(testCase);
		long t1 = System.nanoTime();
		printArr(testCase, "After Sorting ");

		System.out.println("Time taken: " + ((t1-t0)/1000000) + " ms");
	}
}