package gitDSALGO.leetcode;

public class L1446 {
    
    /*
     * Consecutive Characters
     */

     public int maxPower(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        int max = 0;
        while(right<=s.length()-1){
            if(s.charAt(left) == s.charAt(right)){
                longest++;
            }else{
                left = right;
                longest = 1;
            }
            max = Math.max(longest, max);
            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        
    }
}
