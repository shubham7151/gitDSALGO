package gitDSALGO.leetcode;

public class L4_Median_of_Two_Sorted_Arrays {
    /*
     * Median of Two Sorted Arrays
     */

     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        class Solution {
            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
               int[] newArr = new int[nums1.length+nums2.length];
        
                int i = 0,j=0,k=0;
        
                while(i<nums1.length && j < nums2.length){
        
                    if(nums1[i] < nums2[j]){
                        newArr[k] = nums1[i];
                        i++;
                        k++; 
                    }else if(nums2[j] < nums1[i]){
                        newArr[k] = nums2[j];
                        j++;
                        k++; 
                    }else{
                        newArr[k] = nums1[i];
                        i++;
                        k++;
                    }
                    
                }
                while(i<nums1.length){
                        newArr[k]= nums1[i];
                        i++;
                        k++;
                    }
                    while(j<nums2.length){
                        newArr[k]= nums2[j];
                        j++;
                        k++;
                    }
                double mid = 0;
                if(newArr.length%2==0){
                    mid = (newArr[newArr.length/2] + newArr[newArr.length/2 -1 ])/2.0;
                
                }else{
                    mid = newArr[newArr.length/2];
                }
        
                return mid;
            }
        }
    }
}

