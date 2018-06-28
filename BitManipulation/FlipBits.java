import java.util.*;
import java.io.*;



class FlipBits{

	public static void flipBits(long number)
	{
		long[] bits = new long[32];
		
		long temp = number;
		for(int i = 0; i < 32; i++)
		{
			long quo = temp / 2;
			long rem = temp % 2;
			bits[31 - i] = rem;
			temp = quo;
		}

		long sum = 0L;
		for(int i = 0; i < 32; i++){
			long val = bits[i] == 1 ? 0L: 1L;

			sum +=  (val * Math.pow(2, (31-i)));
		}
		System.out.println(sum);
		
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int len = in.nextInt();
		long[] testCases = new long[len];
		for(int i = 0; i < len; i++)
		{
			long number = in.nextLong();
			testCases[i] = number;
		}

		for(long i : testCases){
			flipBits(i);
		}
	}
}