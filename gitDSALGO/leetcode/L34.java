package gitDSALGO.leetcode;

public class L34 {
    
    /*
     * Find First and Last Position of Element in Sorted Array
     */

     /*
      * use binary search to find the element check left then check right
      * continue search even after finding the element.
      */

      public int[] searchRange(int[] nums, int target) {
        // use upper bound and lower bound fo rht element.
        int start = leftCheck(nums,target);
        int end = rightCheck(nums,target);
        
        return start == -1 && end == -1 ? new int[]{-1,-1} : new int[]{start,end};
    }

    public int leftCheck(int[] arr, int t){
        int start = 0;
        int end = arr.length-1;
        int answer = -1;

        while(start<=end){
            int mid = (start + end ) /2 ;
            if(arr[mid] == t){
                answer = mid;
                end= mid-1;
            }else if(arr[mid] < t){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return answer;
    }
    
    public int rightCheck(int[] arr, int t){
        int start = 0;
        int end = arr.length-1;
        int answer = -1;

        while(start<=end){
            int mid = (start + end ) /2 ;
            if(arr[mid] == t){
                answer = mid;
                start = mid+1;
            }else if(arr[mid] < t){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        
    }
}
