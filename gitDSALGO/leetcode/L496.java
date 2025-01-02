package gitDSALGO.leetcode;

public class L496 {
    /*
     * Next Greater Element I
     */

    /*
     * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

        You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.  

        For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

        Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

     */


     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for(int i = 0; i<nums1.length;i++){
            result[i] = rightCheck(nums2,i);
        }

        return result;
     }

     public int rightCheck(int[] num2, int k){
        for(int i = k; i<num2[i];i++){
            if(num2[i] > num2[k] ){
                return i;
            } 
        }
        return -1;
     }
     public static void main(String[] args) {
    
     }
}
