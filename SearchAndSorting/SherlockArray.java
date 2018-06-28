import java.util.*;
import java.io.*;


public class SherlockArray{


	public static String solve(int[] a){
		int len = a.length;
		if(len == 1) return "YES";
       int start = 0; 
       int end = len -1;

       while(start < end){
       	int mid = (start + end) / 2;
       	int val = a[mid];

       	int sumLeft = calcSum(a, 0, mid);
       	int sumRight = calcSum(a, mid + 1, end + 1);
       	System.out.println("Mid Val " + val + " mid idx: " + mid);
       	if(sumLeft == sumRight){
       		System.out.println("sumLeft: " + sumLeft + " sumRight" + sumRight);
       		return "YES";
       	}else if(sumLeft < sumRight){
       		System.out.println("sumLeft: " + sumLeft + " sumRight" + sumRight);
       		start = mid + 1;
       	}else{
       		System.out.println("sumLeft: " + sumLeft + " sumRight" + sumRight);
       		end = mid;
       	}

       }
       return "NO";
    }

    public static int calcSum(int[] a, int start, int end){
    	int sum = 0;

    	for(int i = start; i < end; i++){
    		sum += a[i];
    	}
    	return sum;
    }


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
	}
}