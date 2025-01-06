package gitDSALGO.leetcode;

import java.util.HashSet;

public class L3_Longest_Substring_Without_Repeating_Characters {
    /*
     * Longest Substring Without Repeating Characters
     */

     public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = 0;
        while(right<s.length()){
            while(hs.contains(s.charAt(right))){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(s.charAt(right));
            length = Math.max(length, right-left+1);
            right++;
        }
        
        return length;
        
    }

    public static void main(String[] args) {
        
    }
}
