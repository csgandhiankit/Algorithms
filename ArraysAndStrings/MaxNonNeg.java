import java.util.*;
import java.io.*;

public class MaxNonNeg{




	public static ArrayList<Integer> maxNonNeg(ArrayList<Integer> list){
		ArrayList<Integer> maxArray = new ArrayList<>();
		ArrayList<Integer> newArray = new ArrayList<>();

		long maxSum = 0;
		long newSum = 0;
		for(int i : list){
			if(i >=0){
				newSum += i;
				newArray.add(i);
			}
			else{
				newSum = 0;
				newArray = new ArrayList<Integer>();
			}
			if((maxSum < newSum) || ((maxSum == newSum)&& (newArray.size() > maxArray.size()))){
				maxSum = newSum;
				maxArray = newArray;
			}
		}


		return maxArray;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = {1, 2, 5, -7, 2, 3, 5};
		for(int i : arr){
			list.add(i);
		}

		ArrayList<Integer> res  = maxNonNeg(list);

		for(int i : res){
			System.out.print(i +  " ");
		}
	}

}