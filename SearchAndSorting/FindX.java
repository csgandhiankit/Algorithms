public class FindX{

	//method to find appropriate value for x to satisfy an equation
	public static double findX(double start, double end)
	{
		if(start > end) return -1;
		double mid = 0.0;
		while(start <= end){

	 mid = (start + end) / 2.0;
						System.out.println(mid);
			double logMid = Math.log(mid);
						System.out.println(logMid);
			double equation = mid + logMid;
			if(equation == 0) return mid;
			else if(equation > 0){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		return mid;
	}

	public static int binSearchTest(int[] array,int value, int start, int end){

		if(start > end) return -1;

		int mid = 0;
		
		while(start <= end){
		 mid = (start + end ) / 2;
			if(array[mid] == value){
				return array[mid];
			}else if(array[mid] < value){
				start = mid + 1;
			}else{
				end = mid - 1;
			}

		}

		return -1;

	}


	public static void printArray(int[] arr){
		System.out.print("[ ");
		for(int i : arr){
			System.out.print(i + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		 double start = 0.0; 
		 double end = 1.0;

		 //double x = findX(start, end);
		// System.out.println("x + log x = 0 for x = " + x);


		 int test[] = {1, 2, 3, 4, 5, 6,7, 10, 11, 14, 17, 19 , 23, 222};
		 printArray(test);

		 int[] testCase = {1, 2, 3, 4, 55, 5 ,6 ,3 ,3};

		 for(int i : testCase){
		 int find = binSearchTest(test, i, 0, test.length - 1);


		 String result = find != -1? "Number Found: " + find : "Number " + i + " not found!";

		 System.out.println(result);
		}

	}

}