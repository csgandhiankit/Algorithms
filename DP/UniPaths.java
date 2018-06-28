import java.util.*;
import java.io.*;

public class UniPaths{

	public static void printMatrix(int[][] matrix){
		for(int i = 0;i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void initializeGrid(int[][] matrix){
		for(int i = 0;i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				matrix[i][j] = 1;
			}
			
		}
	}

	//runs in O(n^2) time complexity and O(n * m ) space
	public static int uniPaths(int m, int n){
		int[][] grid = new int[m][n];
		initializeGrid(grid);
		printMatrix(grid);


		for(int i = 1;i < grid.length; i++){
			for(int j = 1; j < grid[0].length; j++){
				grid[i][j] = grid[i-1][j] + grid[i][j-1];
				printMatrix(grid);
			}
			
		}

		return grid[m-1][n-1];

	}


	//binomial formula
	public static int uniquePaths(int m, int n) {
            int N = n + m - 2;// how much steps we need to do
            int k = m - 1; // number of steps that need to go down
            double res = 1;
            // here we calculate the total possible path number 
            // Combination(N, k) = n! / (k!(n - k)!)
            // reduce the numerator and denominator and get
            // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
            for (int i = 1; i <= k; i++)
                res = res * (N - k + i) / i;
            return (int)res;
        }


       //using combinations formula
     public  static int uniquePathsComb(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }
            
        return (int)res;
    }


	public static void printArray(int[] arr){
		System.out.print("[ ");
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.print("]\n");
	}

	//runs in O(n^2) time complexity, space = O(m)
	public static  int uniPathsOptimal(int m, int n){
		if(m > n) return uniPathsOptimal(n, m);

		int[] grid = new int[m];
		for(int i = 0; i  < m; i++){
			grid[i] = 1;
		}

		for (int j = 1; j < n; j++){
            for (int i = 1; i < m; i++){
             
               grid[i] += grid[i - 1]; 
                 printArray(grid);
          	 }
           }
        return grid[m - 1];

	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter value for m and n :");
		int m = in.nextInt();
		int n = in.nextInt();

		int res = uniPathsOptimal(m, n);

		System.out.println("total unique paths possible: " + res);
	}
}