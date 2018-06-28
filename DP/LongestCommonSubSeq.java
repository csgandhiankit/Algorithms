import java.util.*;
import java.io.*;

public class LongestCommonSubSeq{

	public static int longestCommonSub(char[] aa, char[] bb, int m, int n){
		int[][] table = new int[m+1][n+1];

		//Recursive Approach Runtime: O(2^n)
		// if(m == 0 || n == 0) {
		// 	return 0;
		// }

		// if(aa[m-1] == bb[n-1]){
		// 	return 1 + longestCommonSub(aa, bb, m-1, n-1);
		// }
		// else return Math.max(longestCommonSub(aa, bb, m-1, n), longestCommonSub(aa, bb, m, n-1));		

		//Memoization: Runtime: O(mn)

		for(int i = 0; i <= m; i++){
			for(int j = 0; j <= n; j++){
				if(i == 0 || j == 0) {
					table[i][j] = 0;
					printMatrix(table);
				}
				else if(aa[i-1] == bb[j-1]) 
				{
				 table[i][j] = table[i-1][j-1] + 1;
				 printMatrix(table);
				}
				else 
					{
						table[i][j]  = Math.max(table[i-1][j], table[i][j-1]);
						printMatrix(table);
					}

			}
		}
		printLCS(aa, bb, table, table[m][n]);
		return table[m][n];

	}

	public static void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
	  		for(int j = 0; j < m[0].length; j++){
	  			System.out.print(m[i][j] + " ");	
	  		}
	  		System.out.println();
	  	}
        	System.out.println();
    }


    //From Geeks of Geeks 
	public static void printLCS(char[] aa, char[] bb, int[][] L, int lenLCS){
		int index = lenLCS;
        int temp = index;
 
        char[] lcs = new char[index+1];
        lcs[index] = '\0'; // Set the terminating character
  
        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = aa.length, j = bb.length;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (aa[i-1] == bb[j-1])
            {
                // Put current character in result
                lcs[index-1] = aa[i-1];
                 
                // reduce values of i, j and index
                i--; 
                j--; 
                index--;     
            }
  
            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }
  
      System.out.print("LCS:");
        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);

        System.out.println();

	}

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		System.out.println(a + " <==> " + b);
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int res = longestCommonSub(aa, bb, aa.length, bb.length);
		System.out.println("Longest Common Sub-Seq length: " + res);
	}
}