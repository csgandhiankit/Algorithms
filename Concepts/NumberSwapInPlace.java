public class NumberSwapInPlace{
	//swap two numbers without temp (using addition and sub)
	public static void swap(int a, int b){
		System.out.print("Values before swap: \n" + "\ta: " + a + "\tb: " + b + "\n");
		 b = Math.abs(b - a);
		 a = b + a;
		 b = Math.abs(a - b);

		System.out.print("Values after swap: \n" + "\ta: " + a + "\tb: " + b);
	}

	//method 2 to swap two numbers without temp using mul and div
	public static void swap2(int a, int b){
		System.out.print("Values before swap: \n" + "\ta: " + a + "\tb: " + b + "\n");
		a = a * b;
		b = a / b;
		a = a / b; 

		System.out.print("Values after swap: \n" + "\ta: " + a + "\tb: " + b);
	}


	public static void main(String[] args){

		int a = 2;
		int b = 4;	

		swap2(a, b);
	}
}