import java.util.*;
import java.io.*;

public class DavisStarecase{

	public static int numWays(int num){
		int[] ways = new int[num+1];
		if(num == 1) return num;

		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 4;
		for(int i = 4; i <= num; i++){
			ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
		}
		return ways[num];
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		for(int i= 0; i < N; i++){
			int num = in.nextInt();
			int[] memo = new int[num+1];
			System.out.println("Num ways to climb " +  num + ": " + numWays(num));
		}
	}
}