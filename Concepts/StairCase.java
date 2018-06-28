import java.util.*;
import java.io.*;

//fizzbuzz print staircase pattern
public class StairCase{

	public static void printPattern(int n){
		for(int i = 0; i < n; i++){

			for(int j= 0; j < n - 1 - i; j++){
				System.out.print(" ");
			}
			for(int k = 0; k < i + 1; k++){
			System.out.print("#");
		}
		System.out.println();
		}

	}
	public static void printPattern2(int n){

		StringBuilder sb = new StringBuilder();
		sb.append("#");
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%" + (n ) + "s", sb.toString());
			System.out.println();
			sb.append("#");
		}

	}

	public static void main(String[] args){
		int n = 13;
		printPattern2(n);

	}
}