import java.io.*;
import java.util.*;


public class ToRomanNumerals{

int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	public  String toRoman(int num){

		StringBuilder sb = new StringBuilder();
    
    	for(int i=0;i<values.length;i++) {

        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        	}

    	}
	
		return sb.toString();
	}


	public static void main(String[] args){
		ToRomanNumerals t = new ToRomanNumerals();

		int[] testCases = new int[]{1, 2, 4, 5, 7, 8, 9, 10, 11, 15, 19, 20, 25, 30, 31, 33, 37, 39, 40, 1000, 1500, 3999, 4000};

		for(int i : testCases){
			System.out.println(i+ " == > " + t.toRoman(i));
		}
	}
}