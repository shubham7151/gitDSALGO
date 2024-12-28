package gitDSALGO.leetcode;

public class C31 {
    

    /*
     * Next permutation
     * 
     */

     /*
      * first intutuion is to get all possible permutation using recursion : Read it today!!! 
      * Optimal intution : // find the break; means index where there is change in arrays values from 
      *  // find maximum value from the right arraya means index to end
      * // reverse rest of element
      */


      public void nextPermutation(int[] nums) {
        // find the break; means index where there is change in arrays values from 
        int breakIndex = -1;
        for( int i = nums.length-2; i>=0 ; i--){
            if(nums[i] <  nums[i+1]){
                breakIndex = i;
                break;
            }
        }
        if(breakIndex == -1){
                reverse(nums, 0);
        }else {
        // find maximum value from the right arraya means index to end
        
        for(int i = nums.length-1; i >=0;i--){
            if(nums[i] > nums[breakIndex]){
                int temp = nums[i];
                nums[i] = nums[breakIndex];
                nums[breakIndex] = temp;
                break;
            }
        }
        // reverse rest of element
            reverse(nums, breakIndex+1);
        }
    }

    void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        
    }
}
