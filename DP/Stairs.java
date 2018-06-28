 public class Stairs {

	public static int climbStairs(int A) {
	    
	    int ways[] = new int[A + 1];
	    
	    if (A == 1)
	        return 1;
	    
	    ways[1] = 1; //for 1 stair
	    ways[2] = 2; //for 2 stairs
	    
	    for (int i = 3; i <= A; i++) {
	        
	        ways[i] = ways[i - 1] + ways[i - 2]; //fib series 
	  	    }
	    
	    return ways[A];
	    
	}

	public static void main(String[] args) {
		int[] testCase = {2, 3, 4, 5, 6};

		for(int i : testCase){
			System.out.println("Number of ways to climb "+  i  + " steps: " + climbStairs(i));
		}
	}
	
}