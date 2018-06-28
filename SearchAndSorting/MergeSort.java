public class MergeSort{

	public static int count= 0;

	public static void mergeSort(int[] array)
	{
		mergeSort(array, new int[array.length], 0, array.length - 1);
	}


	public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
		if(leftStart >= rightEnd) return;

		int middle = (leftStart + rightEnd) / 2;

		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle + 1, rightEnd);

		mergeHalves(array, temp, leftStart, rightEnd);
	}

	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;

		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
	
		while (left <= leftEnd && right <= rightEnd){
			if(array[left] <= array[right])
			{
				temp[index]  = array[left];
				left++;
				count++;
			}
			else{
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		


		//copy remainder elements 
		System.arraycopy(array, left, temp, index, leftEnd - left + 1);
		System.arraycopy(array, right, temp, index, rightEnd - right  + 1);

		System.arraycopy(temp, leftStart, array, leftStart, size);

	}


	public static void main(String[] args)
	{
		//int[] arr = {2, 3, 4, 5, 2, 1, 44, 6, 77,8};
		int[] arr = {1, 1, 1, 2, 2};
 		//int[] arr ={2, 1, 3, 1, 2};

		for(int i : arr)
		{
			System.out.print(i + ", ");
		}
		System.out.println();
		mergeSort(arr);
		System.out.println("After Sorting:....");
		for(int i : arr)
		{
			System.out.print(i + ", ");
		}
		System.out.println("Num Swaps : "+ count);

	}
}