package gitDSALGO.leetcode;

import java.util.PriorityQueue;

public class L215_Kth_Largest_Element_in_an_Array {
    
    /*
     * Kth Largest Element in an Array
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<nums.length;i++){
            q.add(nums[i]);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.poll();
    }
}
