import java.util.*;

public class RoseK{



	public static void printArr(int[] arr, String str){
		System.out.print(str + ": ");
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static int getKNonEmpty(int[] roses, int k){
		printArr(roses, "Before Sorting");

		Arrays.sort(roses);

		printArr(roses, "After Sorting");
		
		return -1;
	}


	public static void main(String[] args) {
		int[] roses = {2, 5, 3, 1, 4};
		int k = 2;

		int day = getKNonEmpty(roses, k);
		System.out.println("Day :" + day);
	}
}