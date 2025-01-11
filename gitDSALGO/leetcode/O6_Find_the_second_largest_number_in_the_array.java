package gitDSALGO.leetcode;

public class O6_Find_the_second_largest_number_in_the_array {
    /*
     * Find the second largest number in the array
     */

    /*
     * intution : if value is greater then largest then secondLargest = largest and largesr = value else if its greater then second largest and not equals to largest it second largest
     */
    public static int secondLargest(int[] arr){
        int largest = -1;
        int secondLargest = -1;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } else if(arr[i] > secondLargest && arr[i]!= largest){
                secondLargest = largest;
            }
            
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,5,6};
        System.out.println(secondLargest(nums));
    }
}

