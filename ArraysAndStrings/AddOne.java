import java.util.*;
import java.io.*;



public class AddOne{

	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> res = new ArrayList<>();	

		int len = a.size();

		
		int last = a.get(len - 1) + 1;
		int carry = last / 10;
		int lastupdated = last % 10;
		a.set(len - 1, lastupdated);

		for(int i = a.size() - 2; i >= 0; i--){
			int current = a.get(i);
			if(carry > 0){
				current += carry;
				int currentUpdated  =  current % 10;
				a.set(i, currentUpdated);
				carry = current / 10;
			}
			else if(carry == 0) break;
			
		}
		if(carry > 0){
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(carry);
			for(int i : a){
				temp.add(i);
			}
			return temp;
		}

		return a;
	}


	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		int[] l = {9, 9, 9, 9, 9};
		for(int i : l){
			list.add(i);
		}

		ArrayList<Integer> res = plusOne(list);
		for(int i : res){
			System.out.print(i + " ");

		}
		System.out.println();

	}
}