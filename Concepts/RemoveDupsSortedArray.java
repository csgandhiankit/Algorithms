public class RemoveDupsSortedArray{

public static  int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
        if (nums[j] != nums[i]) {
            i++; //increment slow counter when interacted a non-duplicate
            nums[i] = nums[j];
        }
    }
    return i + 1;
}

	public static void main(String[] args){
		int[] test = new int[] {1, 2, 3, 4, 4, 5, 5, 6, 7, 7};
		System.out.println("Before Removing dups:");
		for(int i =0; i < test.length; i++){
			System.out.print(test[i] + " " );
		}
		int result = removeDuplicates(test);


		System.out.println("\n After Removing dups:");

		for(int i =0; i < result; i++){
			System.out.print(test[i] + " ");
		}
	}


}
