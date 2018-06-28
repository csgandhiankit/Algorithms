import java.util.*;
import java.io.*;


public class MiceHoles{

	//Runtime O(n lg n); Collections.sort = mergeSort = O(nlgn)
	public static int mice(ArrayList<Integer> a, ArrayList<Integer> b) {
		if(a == null || b == null || a.size() == 0 || b.size() == 0){return -1;}

		Collections.sort(a);
		Collections.sort(b);
		int time = Integer.MIN_VALUE;

		for(int i = 0; i < a.size(); i++){
			int tempTime = Math.abs(a.get(i) - b.get(i));
			if(tempTime > time){
				time = tempTime;
			}
		}


		return time;
    }



	public static void main(String[] args) {
		int[] pMice = {4, -4, 2, 1};
		int[] pHoles = {4, 0, 5, -5};


		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();

		for(int i : pMice){
			a.add(i);
		}

		for(int i : pHoles){
			b.add(i);
		}

		int time = mice(a,b);
		System.out.println("Time taken : " + time +" minutes");


	}
}