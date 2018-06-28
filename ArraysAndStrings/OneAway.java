import java.util.*; 
import java.io.*;

public class OneAway{


	public static boolean isOneAway(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if(Math.abs(len1-len2) > 1) return false;
		int[] count = new int[26];
		int countNeg = 0;
		for(int i = 0; i < len1; i++){
			count[s1.charAt(i) - 'a']++;
			System.out.println(s1.charAt(i)+ " : " +   count[s1.charAt(i) - 'a']);
		}
		System.out.println("\n");
		for(int i = 0; i < len2; i++){
			count[s2.charAt(i) - 'a']--;
			System.out.println(s2.charAt(i)+ " : " +   count[s2.charAt(i) - 'a']);
			if(count[s2.charAt(i) - 'a'] < 0) {
				countNeg++;
			}
			if(countNeg > 1) return false;
		}

		for(int i : count){
		//	System.out.println(i);
		}
		if (countNeg > 1) {
			return false;
		} 
		else{

		return true;
	}
	}


	//method2 
	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				
				foundDifference = true;
			}
		}
		return true;
	}
	
	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}		
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}	
	
	public static boolean oneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		} 
		return false;
	}



	public static void main(String[] args)
	{
		String s1  = "pale";
		String s2 = "ple";

		String s3 = "pales";
		String s4 = "pale";


		String s5 = "pale";
		String s6 = "bale";

		String s7 = "bake";
		String s8 = "pale";

		String s9 = "sake";
		String s10 = "sake";


		System.out.println(oneEditAway(s1, s2));
		// System.out.println(isOneAway(s1, s2));
		//  System.out.println(isOneAway(s3, s4));

		//  System.out.println(isOneAway(s5, s6));
		//  System.out.println(isOneAway(s7, s8));

		//  System.out.println(isOneAway(s9, s10));





	}
}