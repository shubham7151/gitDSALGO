package gitDSALGO.leetcode;

import java.util.*;

public class L907 {

    /*
     * Sum of Subarray Minimums
     */

     public int sumSubarrayMins(int[] arr) {
        int MOD_VAL = 1000000007;
        long total = 0;
        int[] prev = prevSmallest(arr);
        int[] next = nextSmallest(arr);
        for(int i =0;i<arr.length;i++){
            int left = i- prev[i];
            int right = next[i] -i ;

            total = (total + (long) left * right * arr[i]) % MOD_VAL;
        }

        return (int) total;
    }

    public int[] nextSmallest(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length]; 
        for( int i = arr.length-1;i>=0;i--){

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                result[i] = st.peek();
                
            }else{
                result[i] = arr.length;
            }

            st.push(i);
        }
        return result;
    }

    public int[] prevSmallest(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[arr.length];
        for( int i = 0;i<arr.length;i++){

            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }

            if( !st.isEmpty()){
                result[i] = st.peek();
                
            }else{
                result[i] = -1;
            }

            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        
    }
}
