public class BinarySearch{




	public static boolean binarySearchRecursive(int[] a, int x, int low, int high){
	if(low > high) return false;

	int mid = low + ((high - low) / 2);
	if(a[mid] == x) return true;
	else if(x < a[mid]){
		return binarySearchRecursive(a, x, low, mid -1);
	}else{
		return binarySearchRecursive(a, x, mid + 1, high);
	}


	}

	public static boolean binarySearchRecursive(int[] a, int x){
		return binarySearchRecursive(a, x, 0, a.length-1);
	}


	public static boolean binarySearchIter(int[] a, int x){
		int low = 0;
		int high = a.length - 1;

		while(low <= high){
			int mid = (low + high) / 2;
			int midVal = a[mid];
			if(midVal == x) {
				return true;
			}
			else if(x < midVal)
			{
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return false;
	}


	public static int binarySearch(int[] arr, int x, int low, int high){
		if(low >= high) return -1; //error

		int mid = (low + high) / 2;

		if(arr[mid] < x){
			return binarySearch(arr, x,  mid+1, high);
		}
		else if(arr[mid] > x){
			return binarySearch(arr, x, low, mid-1);
		}
		else
		{
			return arr[mid];
		}
	}



	public static void printArr(int[] a)
	{
		for(int i: a)
		{
			System.out.print(" " +  i);
		}
		System.out.println();
	}



	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 44, 45, 57};

		// int result = binarySearch(arr, 7, 0, arr.length);

		// if(result > 0) {
		// 	System.out.println("Element found!");
		// }
		// else{
		//  System.out.println("No such element");
		// }
		printArr(arr);

		int[] testCases = {1, 3, 5, 8, 9, 33, 3};
		
		System.out.println("binarySearchRecursive ...");
		for(int i : testCases){
			System.out.println(i + " ==> "  + binarySearchRecursive(arr, i));
		}

		System.out.println("\nbinarySearchIter ...");

		for(int i : testCases){
			System.out.println(i + " ==> "  + binarySearchIter(arr, i));
		}





	}
}