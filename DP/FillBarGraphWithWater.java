public class FillBarGraphWithWater{


	//Runs in O(N) time complexity and O(N) space compelexity
	public static int fillGraph(int[] arr){
		if(arr.length < 3) return 0;

		int[] tallestLeft = findTallestLeft(arr);
		int[] tallestRight = findTallestRight(arr);

		// System.out.println("tallest left");
		// printArr(tallestLeft);
		// System.out.println("tallest right");

		printArr(tallestRight);

		int units = 0;
		for(int i = 1; i < arr.length - 1; i++){
			int min = Math.min(tallestLeft[i], tallestRight[i]);
			if(min > arr[i]){
				units += min - arr[i];
			}
			else{
				continue;
			}
		}

		return units > 0? units: 0;

	}


	public static int[] findTallestLeft(int[] arr){
		int[] tallestLeft = new int[arr.length];
		tallestLeft[0] = -1;
		int max = arr[0];
		for(int i = 1; i < tallestLeft.length; i++){
			tallestLeft[i] = max;
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return tallestLeft;
	}

	public static int[] findTallestRight(int[] arr){
		int[] tallestRight = new int[arr.length];
		tallestRight[arr.length - 1] = -1;

		int max = arr[arr.length - 1];
		for(int i = arr.length - 2; i >= 0; i--){
			tallestRight[i] = max;
			if(arr[i] > max){
				max = arr[i];
			}
		}

		return tallestRight;
	}

	public static void printArr(int[] arr){
		for(int i : arr){
			System.out.print(i + " ");

		}
		System.out.println();
	}



	public static void main(String[] args) {
		int[][] testCases = {{5,1, 3, 4}, {5,6,4,7,3,2,8},{5, 3, 1}, {2, 2}};

		for(int[] arr: testCases){
			printArr(arr);
			System.out.println("The graph will hold " + fillGraph(arr) + " units of water");
		}

	}
}