package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L347_Top_K_Frequent_Elements {
    /*
     * Top K Frequent Elements
     */

    public int[] topKFrequent(int[] nums, int k) {
        // get hashmap for frequency
        // create max heap to save most frequenyt element 
        // poll till you get required k element

        HashMap<Integer, Integer> hm = new HashMap<>();
        for( int i : nums){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }

        // pqueue
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> temp : hm.entrySet()){
            pq.add(temp);
        }

        int[] res = new int[k];
        for(int i = 0; i<k;i++){
            res[i] = pq.poll().getKey();
        }

        return res;
        
    }
}
