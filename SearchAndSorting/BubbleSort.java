import java.util.*;
import java.io.*;


public class BubbleSort{


	public static void sort(int[] arr){
		boolean isSorted = false;
		int lastSorted = arr.length - 1;
		while(!isSorted){
			isSorted = true;
			for(int i = 0; i < lastSorted; i++){
				if(arr[i] > arr[i+1]){
					swap(arr, i, i+1);
					isSorted = false;
				}
			}
			lastSorted--;
		}
	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void printArr(int[] arr){
		System.out.print("{ ");
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println("}");
	}

	//Hackerrank Bubble sort Question
	 public static void bSort(int[] arr){
        boolean isSorted = false;
        int lastSorted = arr.length -1;
        int numSwaps = 0;
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < lastSorted; i++){
                if(arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                    isSorted = false; 
                    numSwaps++;
                }
            }
        }
        System.out.println("Array is sorted in " + numSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[arr.length - 1]);


    }


	public static void main(String[] args) {
		int[][] testCases = {{2, 3, 1, 3 ,4 ,5 , 11, 10, 15, 20, 7}, {0, 0, 0, 0, 1}, {1, 9, 7, 8,5, 4, 32}};

		for(int[] arr: testCases){
			printArr(arr);
			sort(arr);
			System.out.println("After Sorting...");
			printArr(arr);
		}
	}
}