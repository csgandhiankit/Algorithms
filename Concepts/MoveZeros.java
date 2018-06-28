public class MoveZeros {
    
    public static void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    
    public static  void moveZeroes(int[] nums) {
        int nextIdx = 0;
        for(int i = 0;i < nums.length; i++){
            if(nums[i] > 0 && i != nextIdx){
                swap(nums, nextIdx, i);
                nextIdx++;
            }
        }
    }


    public static void main(String[] args){
        int[] test = new int[]{0, 0, 0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,1};
        moveZeroes(test);

        for(int i: test){
            System.out.print(i + " ");
        }

    }
}