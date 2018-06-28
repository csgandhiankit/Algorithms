import java.util.*;
import java.io.*;


public class MatrixBS{

	public static int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int number){
		if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) return 0;

		int rows = matrix.size();
		int cols = matrix.get(0).size();
		int start = 0;
		int end = rows * cols - 1;
		System.out.println("end : " + end);
		int mid, x, y;
		while(start <= end){
			mid = (start + end) / 2;
			x = mid / cols;
			y = mid % cols;
			
			if(matrix.get(x).get(y) == number){
				return 1;
			}
			else if(matrix.get(x).get(y) < number){
				start = mid + 1;
			}
			else{
				end = mid - 1;
			}
		}
		return 0;
	}

	public static void printMatrix(ArrayList<ArrayList<Integer>> matrix){
		for(ArrayList<Integer> list: matrix){
			for(int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] grid = {{1,   3,  5,  7},{10, 11, 16, 20}, {23, 30, 34, 50}};
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

		for(int[] i : grid){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j : i){
				temp.add(j);
			}
			matrix.add(temp);
		}

		printMatrix(matrix);

		int res = searchMatrix(matrix, 10);
		System.out.println("Result: "+ res);

	}
}