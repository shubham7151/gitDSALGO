package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class L451_Sort_Characters_By_Frequency {
 
    /*
     * Sort Characters By Frequency
     */

    public String frequencySort(String s) {
        // null check
        // get frequency
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        for( int i = 0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i) ,  hm.get(s.charAt(i)) + 1);
            }else{
                hm.put(s.charAt(i) , 1);
            }
        }
        ArrayList<Character> st = new ArrayList<>(hm.keySet());
        // collection to sort descending order
        st.sort((a,b) -> hm.get(b) - hm.get(a));
        for( Character c : st){
            for( int i = 0; i<hm.get(c); i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
