import java.util.*;
import java.io.*;

public class FindSqrt{

	//brute force
	// runtime complexity = O(sqrt(n))
	public static int calSqrt(int N){

	if(N == 0 || N == 1) return N;
	if(N < 0) return -1; // error
	int i = 1;
	int prod = 1;
	while(prod <= N){
	 	if(prod == N) return i;
	 	i++;
	 	prod = i*i;
	}
	return i - 1; //Math.floor

	}

	//method 2 optimizing runtime from O(aqrt(n)) -- > O(lg n)
	public static int calSqrt2(int N){
		//Random random = new Random();
		if(N == 1 || N == 0) return N;
		int end = N / 2;
		int start = 0;
		int prod = 0;

		while(start <= end){
		 int mid = (end + start) / 2;
			if(mid * mid == N) return  mid;
			else if(mid * mid < N){
				start = mid + 1;
				prod = mid;
			}
			else{
				end = mid - 1;
			}
		}
		return prod;

	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		for(int i = 0; i < n; i++){
		int N = in.nextInt();
		//System.out.println(N + ": " + calSqrt(N));
		System.out.println(N + ": " + calSqrt2(N));

	}

	}
}