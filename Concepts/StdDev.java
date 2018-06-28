import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class StdDev{


	public static String std(int[] arr){
		double sum = 0;

		for(int i : arr){	
			sum += i;
		}
		double mean = sum / arr.length;
		double stdSum = 0;
		for(int i : arr){
			double  temp = Math.pow((i-mean), 2);
			stdSum += temp;
		}
 		
		double ans = Math.sqrt((stdSum/arr.length));
		return new DecimalFormat("#.#").format(ans);

	}

	public static void printArr(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[] arr = new int[N];

		for(int i = 0; i < N; i++){
			arr[i] = in.nextInt();
		}

		String s = std(arr);
		printArr(arr);
		System.out.println("Standard Dev: " +  s);
	}
}