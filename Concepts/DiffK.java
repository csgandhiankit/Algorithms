//Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

import java.util.*;
import java.io.*;

public class DiffK{

	//Runtime = O(n), Space complexity = O(n)
	public static int diffPossible(final List<Integer> a, int b) {
		if(a == null) return 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //key - i, value - complement (k - i)

		int len = a.size();
		if(len == 1) return 0;

		for(int i  = 0; i < len; i++){
			int val = a.get(i);	
			map.put(val, i);
		}

		int idx =0;
		for(int i: a){
			int comp  = i - b;
			if(map.containsKey(comp) && map.get(comp) != idx){
				return 1;
			}
			idx++;
		}
		return 0;
	}




	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		//int N = in.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		// for(int i = 0; i < N; i++){
		// 	a.add(in.nextInt());
		// }
		// int K  = in.nextInt();


		int[] testCase = {34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
		for(int i : testCase){
			a.add(i);
		}
		int K = 97;

		int res = diffPossible(a, K);

		System.out.println(res);
		
	}
}