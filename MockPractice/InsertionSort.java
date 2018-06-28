public class InsertionSort{

	public static void sort(int[] arr)
	{	

		for(int i = 1; i < arr.length; i++){
			int key = arr[i];	
			int j = i - 1;

			while(j >= 0 && arr[j] > key){
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}


	public static void printArr(int[] arr, String label){
		System.out.print(label + ": ");
		for(int i : arr){
			System.out.print(i+ " ");
		}
		System.out.println();
	}



	public static void main(String[] args) {
		int[] testCase = {6, 7, 3, 4, 2, 1,6};
		printArr(testCase, "Before Sorting");
		long t0 = System.nanoTime();
		sort(testCase);
		long t1 = System.nanoTime();
		printArr(testCase, "After Sorting ");

		System.out.println("Time taken: " + ((t1-t0)/1000000) + " ms");
	}
}