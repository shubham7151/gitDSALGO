package gitDSALGO.leetcode;

public class L1752 {
    
    /*
     * Check if Array Is Sorted and Rotated
     * Topic : Arrays
     * check if the array is sorted even if rotated, key point is it will have once instance where ith index is > then i+1th index.
     */

     public boolean check(int[] nums) {
        int change = 0;
        for(int i = 0;i< 2 * nums.length-1; i++){
            if(nums[i] > nums[i+1 % nums.length]){
                change++;
            }
        }
        return change > 1 ? false : true;
    }
    public static void main(String args[]){

    }
}
