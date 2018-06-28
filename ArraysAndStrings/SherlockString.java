import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockString {

	//run time O(n) since characters are constant i.e = 26
	public static boolean checkFreq(int[] freq){
		int f = 0;

		int i = 0;
		for(i = 0; i < freq.length; i++)
		{
			if(freq[i] > 0){
				f = freq[i];
				break;
			}
		}

		//compare rest of the values with first non-zero value found
		for(int j = i + 1; j < freq.length; j++){
			if(freq[j] != 0 && freq[j] != f){
				return false;
			}
		}
		return true;
	}

    public static String isValid(String s){
    	if(s.length() == 0 || s == null) return "NO";
    	int[] freq = new int[26];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //mappign char frequency in a string 
        for(int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
        	freq[c - 'a']++;
        	
        } 
       
        int j = 97;
        for(int i : freq){
        	System.out.println((char) j++ + " : " + i);
        }


        if(checkFreq(freq)) return "YES";

        for(int i = 0; i < 26; i++){
        	if(freq[i] > 0){
        		freq[i]--;

        		if(checkFreq(freq)) return "YES";

        		freq[i]++;
        	}
        }


		return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
