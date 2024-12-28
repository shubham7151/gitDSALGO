package gitDSALGO.leetcode;

public class L1838 {

    /*
     * Frequency of the most frequent element..
     * topics : sorting and sliding window.
     * key : nums[right].windowLength < total + k
     *      reason for that is, if we replace all element from left to right to nums[right] then what will be ideal sum and total represent what will be actial sum. 
     * 
     */

    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int actualSlidingWindowSum = 0;
        int maxLength = 0;
        while(right < nums.length){
            actualSlidingWindowSum+= nums[right];
            while(nums[right] * (right-left+1) >= actualSlidingWindowSum + k){
                actualSlidingWindowSum-= nums[left];
                left++;
            }
            maxLength = Math.max(right-left+1, maxLength);
            right++;
        }

        return maxLength;
    }
    public static void main(String[] args) {
        
    }
}
