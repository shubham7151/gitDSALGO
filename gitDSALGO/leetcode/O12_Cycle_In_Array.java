package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class O12_Cycle_In_Array {

    /*
     *  Cycle In Array 
     */

    public static int lengthOfCycle(int[] arr, int startIndex) {
        // hashmap that keep record of visited index and steps at which it was visited
        HashMap<Integer, Integer> v = new HashMap<>();
        int steps = 0;
        int curr = startIndex;
        while(curr>=0 && curr<arr.length){
            if(v.containsKey(curr)){
                return steps - v.get(curr);
            }
            v.put(curr, steps);
            steps++;
            curr = arr[curr];
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }
}