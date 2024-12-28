package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    
    /*
     * 3Sum problem : three element sum = zero
     * intution fix one index and use two pointer to get sum;
     */

     public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for( int i = 0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int localSum = nums[i]+nums[j]+nums[k];
                if(localSum < 0){
                    j++;
                }else if(localSum > 0){
                    k--;
                }else {
                    List<Integer> st = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(st);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return result;
    }
     public static void main(String[] args) {
        
     }
}
