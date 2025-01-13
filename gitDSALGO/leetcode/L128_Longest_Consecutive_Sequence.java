package gitDSALGO.leetcode;

import java.util.HashSet;

public class L128_Longest_Consecutive_Sequence {
    
    /*
     * Longest Consecutive Sequence
     */

     // use set to store element;
     // check if set[i]-1 exist in set if so use set to continue sequence 

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length==1)return 1;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        int max = 1;
        for(int i : hs){
            if(hs.contains(i-1)){
                int x = i;
                int c = 1;
                while(hs.contains(x+1)){
                    x++;
                    c++;
                }
                max = Math.min(c, max);
            }
        }
        return max;
    }
}
