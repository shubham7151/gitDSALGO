package gitDSALGO.leetcode;

public class L283 {
    
    /*
     * Moves Zeros
     */

    /*
     * intution : find first zero and swap with any element which is non zero.
     */

     public void moveZeroes(int[] nums) {
        if (nums.length ==1) return;
        int j = -1;
        for(int i=0 ; i<nums.length;i++ ){
            if(nums[i]== 0){
                j=i;
                break;
            }
        }
        if(j==-1) return;
        for(int i = j+1; i<nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] =  nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
