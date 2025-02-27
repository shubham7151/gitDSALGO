package gitDSALGO.leetcode;

public class L2154_Keep_Multiplying_Found_Values_by_Two {
    
    /*
     * Keep Multiplying Found Values by Two
     */

     public int findFinalValue(int[] nums, int original) {
        
        while(search(nums,original)){
            original*=2;
        }
        return original;
    }

    public boolean search(int[] nums, int original){
       for( int i = 0; i<nums.length; i++){
        if(nums[i] == original){
            return true;
        }
       }
       return false;
    }
}
