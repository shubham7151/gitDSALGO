package gitDSALGO.leetcode;

import java.util.List;
import java.util.*;

public class L692_Top_K_Frequent_Words {
    
    /*
     * Top K Frequent Words
     */

     public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> hs = new HashMap<>();
        for(String s : words){
            hs.put(s, hs.getOrDefault(s, 0)+1);
        }

        ArrayList<String> arr = new ArrayList<>(hs.keySet());
        Collections.sort(arr,(a,b)-> hs.get(a).equals(hs.get(b)) ? a.compareTo(b) : hs.get(b)-hs.get(a));
        return arr.subList(0, k);
     }
}
