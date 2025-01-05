package gitDSALGO.leetcode;

import java.util.HashMap;

public class L242_Valid_Anagram {
    
    /*
     * Valid Anagram
     */

    public boolean isAnagram(String s, String t) {
        //check null
        if(s==null || t == null){
            return false;
        }
        //check length
        if(s.length()!=t.length()){
            return false;
        }
        
        //count frequencey  
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(int i = 0; i<s.length();i++){
            if(smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i) , smap.get(s.charAt(i)) +1 );
            }else{
                smap.put(s.charAt(i) ,  1);
            }
            if(tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i) , tmap.get(t.charAt(i)) +1 );
            }else{
                tmap.put(t.charAt(i) ,  1);
            }
            
        }
        return smap.equals(tmap) ? true : false;
    }
    public static void main(String[] args) {
        
    }
}
