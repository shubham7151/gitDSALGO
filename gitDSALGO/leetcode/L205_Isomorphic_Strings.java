package gitDSALGO.leetcode;

import java.util.HashMap;

public class L205_Isomorphic_Strings {

    /*
     * Isomorphic Strings
     */

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> firstStr = new HashMap<>();
        HashMap<Character, Character> secondStr = new HashMap<>();

        for(int i = 0; i<s.length();i++){
            firstStr.put(s.charAt(i) , t.charAt(i));
        }

        for(int i = 0; i<t.length();i++){
            secondStr.put(t.charAt(i) , s.charAt(i));
        }

         for(int i = 0; i<s.length();i++){
            if(firstStr.get(s.charAt(i))  != t.charAt(i)){
                return false;
            }
            if(secondStr.get(t.charAt(i))  != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}