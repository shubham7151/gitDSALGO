package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L560 {
    
    /*
     * Subarray Sum Equals K
     */

    
     public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hp = new HashMap<>();
        int sum =0;
        int res = 0;
        hp.put(0,1);
        for(int i = 0 ;i<nums.length;i++){
            sum+= nums[i];

            if(hp.containsKey(sum - k)){
                res += hp.get(sum-k);
            }
            hp.put(sum, hp.getOrDefault(sum,0) +1);
        }

        return res;
    }

    public static void main(String[] args) {
        
    }
}
