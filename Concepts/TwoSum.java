public class TwoSum {


    //todo: check for negative numbers
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while(i < nums.length && j >=0 ){
            sum = nums[i] + nums[j];
            if(sum > target &&  target > 0){
                j--;
            }
            else if(sum < target && target > 0){
                i++;
            }
            else if(sum > target &&  target < 0){
                i++;
            }
            else if (sum < target && target < 0) {
                j--;
            }
            else if(sum == target){
               return new int[] {i, j};
            }
        }
        return null;       
    }

    public static void printArr(int[] a){
        System.out.print("[ ");
         for(int i: a){
             System.out.print(i + " ");
        }
        System.out.print("]\n");

    }

    public static void main(String[] args){

        int[] test = new int[] {1, 2, 3, 4, 7};
       int[] testNeg = new int[]{-1,-2,-3,-4,-5};
       int[] indices = twoSum(test, 7);
       int[] negIndices = twoSum(testNeg, -8);   

        printArr(test);
        printArr(indices);

        printArr(testNeg);
        printArr(negIndices);
    
    }
}