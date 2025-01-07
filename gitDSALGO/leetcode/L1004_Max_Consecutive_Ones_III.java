package gitDSALGO.leetcode;

public class L1004_Max_Consecutive_Ones_III {
    
    /*
     * Max Consecutive Ones III
     */

    /*
     * brute force
     */
    public static int longestOnes(int[] nums, int k) {
        int max = 0;

        for(int i = 0; i<nums.length;i++){
            int c = 0;
            for(int j = i;j<nums.length;j++){
                if(nums[j] ==  0){
                    c++;
            }
            if(c<=k){
            max = Math.max(max, j-i+1);

            }else{
                break;
            }
        }
        }   
        return max;
    }

    /*
     * Optimal approach
     */

     public int longestOnesOptimize(int[] nums, int k) {
        
            int left = 0;
            int right = 0;
            int max = 0;
            int c = 0;
            while(right < nums.length){
                if(nums[right] == 0){
                    c++;
                }
                if(c<=k){
                    max = Math.max(max, right-left+1);
                }else{
                    while(c>k){
                        if(nums[left] ==0){
                            c--;
                        }
                        left++;
                    }
                }
                
    
                right++;
            }
    
            return max;
        }


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        System.out.println(longestOnes(arr,k));
    }
}
