import java.io.*;
import java.util.*;

//Iterview bit question 
public class UniquePathsGrid{
	private int grid[][];

	private ArrayList<ArrayList<Integer>> A;


	public  void printMatrix(int[][] m){
        for(int i = 0; i < m.length; i++){
	  		for(int j = 0; j < m[0].length; j++){
	  			System.out.print(m[i][j] + " ");	
	  		}
	  		System.out.println();
	  	}
        	System.out.println();
    }

    public void printGrid(ArrayList<ArrayList<Integer>> A){
    for(int i  = 0; i < A.size(); i++)
	  	{
	  		for(int j = 0; j < A.get(0).size(); j++){
	  			System.out.print(A.get(i).get(j) + " ");
	  		}
	  		System.out.println("");
	  	}
    }
    
	public  int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	  	if(a == null) return 0;
	  	

	  	int m = a.size();
	  	int n = a.get(0).size();

	  	if(m == 0 || n == 0) return 0;

	  	this.grid = new int[m][n];
	  	//populating matrix with -1
	  	for (int i = 0; i < m; i++)
	        Arrays.fill(grid[i], -1);

	  

	  	this.A = a;

	  	printGrid(A); //debugging 
	  	

	  	if(A.get(0).get(0) == 0)
	  	{
	  		grid[0][0] = 1;
	  	}

	  	printMatrix(grid);
	  
	  	uniquePathsWithObstacles(m-1, n-1);
	  	printMatrix(grid);
	    return grid[m-1][n-1];
	}


	public  int uniquePathsWithObstacles(int i, int j){	
	if(i < 0 || j < 0) return 0;

		if(grid[i][j] != -1) return grid[i][j];

		if(A.get(i).get(j) == 1) return grid[i][j] = 0;

		grid[i][j] = uniquePathsWithObstacles(i-1, j) + uniquePathsWithObstacles(i, j-1);
		printMatrix(grid);

		return grid[i][j];
	}  




	public static void main(String[] args){
		UniquePathsGrid u = new UniquePathsGrid();
		ArrayList<ArrayList<Integer>> grid = new ArrayList<ArrayList<Integer>>(); 
		ArrayList<Integer> l1  =  new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		ArrayList<Integer> l2  =  new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		ArrayList<Integer> l3  =  new ArrayList<Integer>(Arrays.asList(0, 0, 1));
		ArrayList<Integer> l4  =  new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		grid.add(l1);
		grid.add(l2);
		grid.add(l3);
		grid.add(l4);

		int res = u.uniquePathsWithObstacles(grid);
		System.out.println("Num of paths : " + res);

	}
}