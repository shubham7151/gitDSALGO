package gitDSALGO.leetcode;

public class L35 {

    /*
     * Search Insert Position
     */

    public int searchInsert(int[] nums, int target) {
        int answer = nums.length;
        int start = 0;
        int end = nums.length-1;
        if(nums[start] > target){
            return start;
        }
        while(start<=end){
        int mid = (start + end)/2;
            if(nums[mid] >= target){
                if(mid < answer)
                answer = mid;
                end = mid -1;
            }else {
                start = mid +1;
            }
        }
        return answer;
        }
    public static void main(String[] args) {
        
    }
    
}
