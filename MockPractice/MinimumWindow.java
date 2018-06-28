import java.util.*;
import java.io.*;

public class MinimumWindow{


	/***********BRUTE FORCE RUNTIME O(***********************/
	public static boolean checkSubstring(String t, String sub){
		for(int i = 0; i < t.length(); i++)	
		{
			CharSequence s = t.charAt(i)+ "";
			if(!sub.contains(s))
			{
				return false;
			}
		}
		return true;
	}

	public static String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";
        for(int i = 0; i < s.length(); i++){
        	for(int j = i; j < s.length(); j++){
        		String sub  = s.substring(i, j + 1);
        		if(sub.length() >= t.length())
        		{
        			boolean res = checkSubstring(t, sub);
        			if(res == true && sub.length() < minLength){
        				minLength = sub.length();
        				minWindow = sub;
        			}
        		}
        	}
        }

        return minWindow;
    }
/*********************************************************/
	
	public static String minWindowOptimal(String s, String t) {
		String minWindow = "";
		int lenMinWindow = Integer.MAX_VALUE;
		int lenS = s.length();
		int lenT = t.length();
		if(lenS < lenT)
		{
			return minWindow;
		}

		int map_s[] = new int[256];
		int map_t[] = new int[256];

		for(int i = 0; i < lenT; i++){
			map_t[t.charAt(i)]++;
		}

		int start = 0, startIdx = -1;

		int count = 0;

		for(int i = 0; i < lenS; i++){
			map_s[s.charAt(i)]++;

			if(map_t[s.charAt(i)] != 0 && map_s[s.charAt(i)] <= map_t[s.charAt(i)]) count++;

			if(count == lenT){
				//System.out.println("in here for i =" + i);
				//Remove characters from front if char count in s > char count in t
				// System.out.println("start: " + start + " i:  " + i);
				while(map_s[s.charAt(start)] > map_t[s.charAt(start)] || map_t[s.charAt(start)] == 0){

					if(map_s[s.charAt(start)] > map_t[s.charAt(start)]) map_s[s.charAt(start)]--;
					start++;
					System.out.println("start: " + start + " i:  " + i);
				}

				int len_window = i - start  + 1;

				//update window length
				if(len_window < lenMinWindow){
					lenMinWindow = len_window;
					startIdx = start;
				}
			}
		}
		if(startIdx == -1){
			return "";
		}

		return s.substring(startIdx, startIdx + lenMinWindow);
	}

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";

		long t0 = System.currentTimeMillis();
		String res1 = minWindow(s, t);
		long t1 = System.currentTimeMillis();

		System.out.println("Min Window: " + res1);
		System.out.println("Time taken Brute Force (ms): " + (t1-t0));

		long t2 = System.currentTimeMillis();
		String res = minWindowOptimal(s, t);
		long t3 = System.currentTimeMillis();

		System.out.println("Min Window: " + res);
		System.out.println("Time taken (ms): " + (t3-t2));


	}
}