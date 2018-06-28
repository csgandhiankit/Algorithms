import java.util.*;
import java.io.*;

public class TripletSum{



	public static void findTriplet(int[] arr, int Sum){
		int start = 0;
		int end = arr.length -1;
		int mid = (start + end ) / 2;
		int sum = 0;
		for(int i = 0; i < arr.length - 2; i++){
		int j = i + 1;
		int k = arr.length - 1;
		while(j < k){
			sum = arr[j] + arr[k] + arr[i];
			if(sum == Sum){
				System.out.println("Triplets: "+ arr[i] + " + " + arr[j] + " + " +arr[k] + " = " + sum);
				return;
			}else if(sum < Sum){
				j++;
			}else{
				k--;
			}

		}
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
		int[] testCase = {1, 2, 3, 4, 5, 34, 4, 3}; //sorted array
		int sum = 38;
		printArr(testCase, " Sum: " + sum);
		long t0 = System.nanoTime();
		findTriplet(testCase, sum);
		long t1 = System.nanoTime();
		
		System.out.println("Time taken: " + ((t1-t0)/1000000) + " ms");
	}
}