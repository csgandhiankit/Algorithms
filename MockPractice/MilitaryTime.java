import java.util.*;
import java.io.*;

public class MilitaryTime{


	public static String convertTimeToMil(int A, int B, int C, int D){
		char[] arr = str.toCharArray();

	}

	public static void main(String[] args) {
		String[] testCases = {"01:00", "23:00", "22:33"};

		for(String s: testCases){
			System.out.println(s + " => " + convertTimeToMil(s));
		}
	}
}