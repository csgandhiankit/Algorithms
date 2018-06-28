import java.util.*;
import java.io.*;


public class RomansToInt{

	// String[] symbols = {"M", "D", "C", "L", "X", "V", "I"};
	// int[] values = {1000, 500, 100, 50, 10, 5, 1};



public static int romansToInt(String s){

		int[] nums = new int[s.length()];
		for(int i=0;i<s.length();i++){
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
		int sum = 0; 

		for(int i = 0; i < nums.length -  1; i++)
		{
			if(nums[i] < nums[i + 1])
			{
				sum -= nums[i];
			}
			else{
				sum += nums[i];
			}

		}

		return sum + nums[nums.length - 1];

	}






	public static void main(String[] args){
		String[] testCases = {"I", "V", "X", "IX", "XX", "CCX", "MMC"};

		for(String s : testCases)
		{
			System.out.println(romansToInt(s));
		}


	}
}