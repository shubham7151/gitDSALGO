package gitDSALGO.leetcode;

import java.util.HashMap;
import java.util.Map;

public class O4_Find_the_missing_alphabets_from_a_panagram {
    
    /*
     * Find the missing alphabets from a panagram 
     */

    final static  String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static  String missingAlphabeString(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char ch= 'a';
        for( int i = 0; i<s.length();i++){
            if(!s.contains(String.valueOf(ch))){
                sb.append(ch);
            }
            ch++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "The quic brown for jumps over the lazy dog";
        System.out.println(missingAlphabeString(s));
    }
}
