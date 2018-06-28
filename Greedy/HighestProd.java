import java.util.*;
import java.io.*;


public class HighestProd{

	public static int maxp3(ArrayList<Integer> a){

		PriorityQueue<Integer> min = new PriorityQueue<Integer>(); //min heap

		PriorityQueue<Integer> q = new PriorityQueue<Integer>(a.size(), new Comparator<Integer>(){ //max heap
			public int compare(Integer a, Integer b){
				return -1 * a.compareTo(b);
			}
		});
        
        for(int i : a){
            q.add(i);
            min.add(i);
        }


        int sumMax3 = 1; //product of max 3 values 
        int maxVal = q.peek(); //save max value
        for(int i = 0; i < 3; i++){
        	int val = q.poll();
        	sumMax3 *= val;
        } 
        int sumMax2 = 1; //product of min 2 values
        for(int i = 0; i < 2; i++){
        	int val = min.poll();
        	if(val < 0){
        		sumMax2 *= val;
        	}
        }

        return sumMax3 < (maxVal * sumMax2)? (maxVal*sumMax2) : sumMax3;
	}


	public static void printArr(int[] arr){
		System.out.print("[ ");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		System.out.println("]");
	}


	public static void main(String[] args) {
	ArrayList<Integer> a = new ArrayList<Integer>();
	ArrayList<Integer> b = new ArrayList<Integer>();

	int[] testCase1 = {0, -1, 3, 100, 70, 50};
	int[] testCase2 = {0, -1, 3, 100, -70, -50};

	for(int i : testCase1){
		a.add(i);
	}
	for(int i : testCase2){
		b.add(i);
	}
	printArr(testCase1);
	int res1 = maxp3(a);
	System.out.println("HighestProduct: " + res1);

	printArr(testCase2);
	int res2 = maxp3(b);
	System.out.println("HighestProduct: " + res2);


	}
}