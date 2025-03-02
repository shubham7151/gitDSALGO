package gitDSALGO.Concepts;

import java.util.ArrayList;
import java.util.List;

public class Phonepad {
    
    /*
     * old phone pad find all combination when pressed specific digits 
     * for instance "12"
     * 1-> abc 2-> def
     * ad,ae,af,bd,be,bf,cd,ce,cf
     */


    public static void printCombinationPhonePad(String s){
        printCombinationPhonePadHelper("",s);
    }

    public static void printCombinationPhonePadHelper(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) -'0';

        for( int i = (digit-1)*3; i< digit*3;i++){
            char ch = (char) (i+'a');
            printCombinationPhonePadHelper(p+ch, up.substring(1));
        }
    }

    /*
     * Combinational sum 
     * 
     */

    public static List<List<Integer>> combinationSum(int[] nums, int target){
        System.out.println(combinationSum(nums, 0, target));
        return null;
       
    }

    public static List<Integer> combinationSum(int[] nums,int j, int target){
        if(target==0){
            List<Integer> ret = new ArrayList<>();
            ret.add(nums[j]);
            return ret;
        }

        List<Integer> rr = new ArrayList<>();
        for( int i = j; i<nums.length && nums[i] < target;i++){
            rr.addAll(combinationSum(nums,i,target-nums[i]));
        }
        return rr;
    }
    
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
}
