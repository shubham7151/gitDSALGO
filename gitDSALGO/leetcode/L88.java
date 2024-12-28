package gitDSALGO.leetcode;

public class L88 {
    

    /*
     * Merge two sorted array without extra space
     */

     public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = n+m-1;
        while(i >= 0 && j >= 0 ){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // i not needed as they are already inplace
         while( j >= 0){
            nums1[k]= nums2[j];
            k--;
            j--;
        }
    }
    public static void main(String[] args) {
        
    }
}
