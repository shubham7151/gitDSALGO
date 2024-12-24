package gitDSALGO.leetcode;

public class C189 {
    
    /*
     * Rotate Array 
     */
    /*
     *
     * Topic Arrays,Two Pointers
     * complexcity : O(N^2) 
     */
    public static void rotate(int[] nums, int k){
        for(int j = 0;j< k % nums.length;j++){
            int temp = nums[nums.length-1];
            for( int i = nums.length-1;i >0;i--){
                nums[i] = nums[i-1]; 
            }
            nums[0] =  temp;
        }
        
    }
    /*
     *
     * intution : reverse whole array, reverse array from 0 to k then k to end; 
     * Complexicity O(N)
     */

    public static void rotateArr(int[] arr, int k){

        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
    }

    public static int[] reverse(int[] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]  = temp;
            start++; end--;
        }

        return arr;
    }
        
    public static void main(String[] args) {
        
    }
}
