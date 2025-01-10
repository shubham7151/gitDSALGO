package gitDSALGO.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L1832_Check_if_the_Sentence_Is_Pangram {
    
    /*
     * Check if the Sentence Is Pangram
     */

    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for( int i = 0;i<sentence.length(); i++){
            set.add(sentence.charAt(i));
        }

        return set.size() == 26 ? true : false;
    }

    public static void main(String[] args) {
        
    }
}
