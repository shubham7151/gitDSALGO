package gitDSALGO.leetcode;

public class O7_Write_a_pgm_to_find_the_second_smallest_number {
    
    /*
     * Write a pgm to find the second smallest number.
     */


    public static int secondSmallestNumber(int[] a){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for( int i = 0;i<a.length;i++){
            if(a[i] < smallest){
                secondSmallest = smallest;
                smallest = a[i];
            }else if( a[i] < secondSmallest && a[i]!= smallest){
                secondSmallest = a[i];
            }
        }

        return secondSmallest;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,5,6};
        System.out.println(secondSmallestNumber(nums));
    }
}
