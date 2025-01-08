package gitDSALGO.leetcode;

import java.util.HashMap;

public class L930_Binary_Subarrays_With_Sum {
    
    /*
     * Binary Subarrays With Sum
     */

    // intution is to have hashmap and prefix sum and if prefixsum - k contains in hashmap add to count; which means
    // k is in the hashmap ending at ith index;
    public int numSubarraysWithSum(int[] nums, int goal) {
        // simple sliding window wont work
        // intution is have hashamap keep prefixsum - goal
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        int prefixSum = 0;int result = 0;
        for( int i = 0; i<  nums.length;i++){
            prefixSum += nums[i];
            int rem = prefixSum - goal;
            if(mp.containsKey(rem)){
                result += mp.get(rem);
            }
            mp.put(prefixSum, mp.getOrDefault(prefixSum, 0) +1);
        }

        return result;
    }
}
