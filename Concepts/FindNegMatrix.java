import java.util.*;
import java.io.*;


public class FindNegMatrix{



	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j< matrix[0].length; j++){
				System.out.printf("%3s",matrix[i][j]);
			}
			System.out.println("");
		}
	}

	public static  int countNeg(int[][] matrix)
	{
		int count = 0;

		int row = 0;
		int col = matrix[0].length -1 ;

		while(col >= 0 && row < matrix.length){
			if(matrix[row][col] >= 0){
				col--;
				continue;
			}
			count += col + 1;

			row++;
		}


		return count;
	}


	public static void main(String[] args) {
		
		int[][] matrix = new int[][]{{-3, -2, -1, 1, 2, 3},
									 {-2, -1, 3, 4, 5, 6},
									 {-1,  0, 7, 8, 9, 10}
									};

		printMatrix(matrix);
		System.out.println("Number of neg integers : " + countNeg(matrix));

	}
}