package gitDSALGO.leetcode;

import java.util.*;
public class Basic_1 {
    
    /*
     * implement lower bound
     * Topic : Binary search 
     * Learning basics : 
     * What is lower bound ??
     * it finds the first or the smallest element index in sorted array where the value at index is greater than or equal to the key.
     */

    /*
     * can be done using binary search 
     * 
     */

    public static int findUpperBound(List<Integer> array, int target){
        int answer = -1;

        int start = 0;
        int end = array.size()-1;
        while(start < end){
            int mid = (start+end)/2;
            if(array.get(mid) <= target){
                if(mid > answer) answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,3,5,8,8,10,10,11));

        System.out.println("Lower bound ");
        System.out.println(findLowerBound(arr,9));
    }
}
