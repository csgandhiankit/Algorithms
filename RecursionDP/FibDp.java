
// generating fib series using dynamic programming
public class FibDp{


	public static int fib(int n, int[] memo){
		if(n <= 0) 
			{
				return 0;
			}
		else if(n == 1) 
			{
				return 1;
			}
		else if(memo[n] == 0){
			memo[n] = fib(n-1, memo) + fib(n-2, memo);
		}
		return memo[n];

	}




	public static void main(String[] args)
	{

		int n = 7;
		int[] memo = new int[n+1];
		int result = fib(n, memo);
		System.out.println(result);

	}


}