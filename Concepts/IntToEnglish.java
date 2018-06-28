import java.util.*;
import java.io.*;

// converts integers to english wordsgs
public class IntToEnglish{


	final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
	"Seventeen", "Eighteen", "Nineteen"};
	final String[] belowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String intToEnglish(int N){
		StringBuilder sb = new StringBuilder();
		if(N == 0) return "Zero";

		if(N < 10){
			sb.append(belowTen[N]);
		}
		else if(N < 20){
			sb.append(belowTwenty[N - 10]);
		}
		else if(N < 100){
			int prefix = N / 10;
			int postfix = N % 10;
			sb.append(belowHundred[prefix] + " ");
			sb.append(belowTen[postfix]);
		}
		else if(N < 1000){
			int prefix = N / 100;
			int postfix = N % 100;
			sb.append(intToEnglish(prefix) + " Hundred " + intToEnglish(postfix));
		}
		else if(N < 1000000){
			int prefix = N / 1000;
			int postfix = N % 1000;
			sb.append(intToEnglish(prefix) + " Thousand " + intToEnglish(postfix));
		}
		else if(N < 1000000000){
			int prefix = N / 1000000;
			int postfix =  N % 1000000;

			sb.append(intToEnglish(prefix) + " Million " + intToEnglish(postfix));

		}
		else{
			int prefix = N / 1000000000;
			int postfix  =N % 1000000000;
			sb.append(intToEnglish(prefix) + " Billion " + intToEnglish(postfix));
		}

		return sb.toString();

	}



	public static void main(String[] args){
		IntToEnglish eng = new IntToEnglish();
		int[] testCases = {0, 1, 2, 3, 4, 5, 10, 11, 15, 20, 25, 45, 30, 40,42, 50, 67, 101, 455, 566, 799, 999, 1222, 2333, 890009, 23030304, 23323, 242444, 34343, 1231202349};

		for(int i : testCases){
			System.out.println(i + " ==> "+ eng.intToEnglish(i));
		}

	}
}