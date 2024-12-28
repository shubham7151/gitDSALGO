package gitDSALGO.leetcode;

public class C26 {

    /*
     * Remove the duplicate from sorted Array
     * Topic : Arrays two pointers
     * intution : one pointer iterate through the arrays and other check for unique element
     */
    public int removeDuplicates(int[] nums) {
        int uniqueElement = 0;
        for(int iterator = 1; iterator< nums.length;iterator++){
            // so if element is unique increase uniquelement place holder and place iterator to element place 
            if(nums[iterator] != nums[uniqueElement]){
                uniqueElement++;
                nums[uniqueElement] = nums[iterator];
            }
            
        }
        return uniqueElement+1;
    }
    public static void main(String[] args) {
        
    }
    
}
