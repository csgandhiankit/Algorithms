import java.util.*;
import java.io.*;

public class OrderHeights{

	// static class Person{
	// 	private int height;
	// 	private int infront;
	// 	public Person(int height, int infront){
	// 		this.height = height;
	// 		this.infront = infront;
	// 	}

	// 	public int getHeight(){
	// 		return this.height;
	// 	}
	// 	public int getInfront(){
	// 		return this.infront;
	// 	}
	// }


	/*
	* Brute force: Generate permutations of heights and measure 
	* number of persons in front of a person
	* Run time: O(N!) 
	*/
	public static int[] correctOrderBruteForce(int[] heights, int[] infronts){
		int[] corrOrder = new int[heights.length];

		generatePerms(0, heights, infronts);


		return corrOrder;
	}


	public static void computeAndCompareOrder(int[] list, int[] infronts)
	{	
		boolean check = true;
		int[] ins = new int[list.length];
		int len = list.length;
		for(int i = len - 1; i >= 0; i--){
			int count = 0;
			for(int j = 0; j < i; j++){
				if(list[j] > list[i])
				{
					count++;
				}
			}
			ins[i] = count;
		}

		for(int i = 0; i < list.length; i++){
			if(ins[i] != infronts[i]){
				check = false;
			}
		}
		if(check == true){
			printArr(list, "Actual Output");
		}

	}

	public static void generatePerms(int startIdx, int[] list, int[] infronts){
		if(startIdx == list.length){
			computeAndCompareOrder(list, infronts);
			//printArr(list, "");
			return;
		}
		for(int i = startIdx; i < list.length; i++){
			int temp = list[i];
			list[i] = list[startIdx];
			list[startIdx] = temp;
			

			generatePerms(startIdx + 1, list, infronts);


			int tem  = list[i];
			list[i] = list[startIdx];
			list[startIdx] = tem;
		}

		
	}

/************************O(N^2) Method ******************************/

	public static int[] corrOrder(int[] heights, int[] infronts){
		int[] result = new int[heights.length];
		int[] sortedHeights = heights.clone();
		int[] sortedInfronts = new int[infronts.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < heights.length; i++){
			map.put(heights[i], infronts[i]);
		}
		//Map<Integer, Integer> sortedMap = new TreeMap<>(map);
		Arrays.sort(sortedHeights);

		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < infronts.length; i++){
			indices.add(i);
		}
		
		printArr(sortedHeights, "sortedHeights");
		
		for(int i = 0; i < infronts.length; i++){
			int idx = map.get(sortedHeights[i]);
			sortedInfronts[i] = idx;
		}

		printArr(sortedInfronts, "sortedInfronts");


		for(int i : sortedHeights){
			int val = map.get(i);
			int idx = indices.get(val);
			result[idx]  = i;
			indices.remove(indices.indexOf(idx));
		}



		return result; 

	}


	/***************** Best Optimized Solution (Tress/segment tree)*****/

	public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts){
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();

		ArrayList<Integer> result = new ArrayList<>();
		//building treemap with heights and infronts
		for(int i = 0; i < heights.size(); i++){
			if(map.get(heights.get(i)) == null){
				map.put(heights.get(i), new ArrayList<Integer>());
			}
			map.get(heights.get(i)).add(infronts.get(i));
		}

		while(!map.isEmpty()){
			int height = map.lastKey();
			
			ArrayList<Integer> infront = map.get(height);
			int temp =  infront.get(0);
			System.out.printf("Height: %d : Infront: %d\n", height, temp);
			infront.remove(0);
			if(infront.size() == 0){
				map.remove(height);
			}
			if(result.size() == 0){
				result.add(height);
			}else{
				result.add(temp, height);
			}

		}


		return result;
	}
	

	public static void printArr(int[] arr, String msg){
		System.out.print(msg + ": [ ");
		for(int i : arr){
			System.out.print(i +  " ");

		}
		System.out.println("]");
	}


	public static void main(String[] args) {
		int[] h = {1, 2, 3};
		int[] heights = {5, 3, 2, 6, 1, 4};
		int[] infronts = {0, 1, 2, 0, 3, 2};

		ArrayList<Integer> hh = new ArrayList<>();
		ArrayList<Integer> ii = new ArrayList<>();

		for(int i : heights){
			hh.add(i);
		}
		for(int i : infronts){
			ii.add(i);
		}

		printArr(heights, "Heights");
		printArr(infronts, "Infronts");

		//int[] result = correctOrderBruteForce(heights, infronts);

		int[] res = corrOrder(heights, infronts);
		//printArr(res, "Actual Order");

		//optimized solution
		ArrayList<Integer> result = order(hh, ii);
		System.out.print("Actual Order: ");
		for(int i : result){
			System.out.print(i + " ");
		}
	}	
}