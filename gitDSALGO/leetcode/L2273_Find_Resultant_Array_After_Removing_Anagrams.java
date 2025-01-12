package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2273_Find_Resultant_Array_After_Removing_Anagrams {
    /*
     * Find Resultant Array After Removing Anagrams
     */


    public List<String> removeAnagrams(String[] words) {
    List<String> res = new ArrayList<>();
    res.add(words[0]);
    for(int i = 1; i<words.length; i++){
        if(!anagrams(words[i] , words[i-1])){
            res.add(words[i]);
        }
    }
        return res;
    }

    public boolean anagrams(String s1, String s2) {
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
