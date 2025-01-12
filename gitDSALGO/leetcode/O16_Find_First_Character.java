package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.*;

public class O16_Find_First_Character {
    /*
     *     23. char findFirst(String input)
            1.   * Finds the first character that does not repeat anywhere in the input string
            2.   * If all characters are repeated, return 0
            3.   * Given "apple", the answer is "a"
            4.   * Given "racecars", the answer is "e"
            5.   * Given "ababdc", the answer is "d"
     */

    public static char findFirst(String input){
        //count frequency
        //check whose frequency is 1 from start.
        HashMap<Character, Integer> hs = new HashMap<>();

        for(Character st : input.toCharArray()){
            if(hs.containsKey(st)){
                hs.put(st, hs.get(st) +1);
            }else{
                hs.put(st, 1);
            }
        }
        
        for(Character st : input.toCharArray()){
            if(hs.get(st) == 1){
                return st;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(findFirst("ababdc"));
    }
}
