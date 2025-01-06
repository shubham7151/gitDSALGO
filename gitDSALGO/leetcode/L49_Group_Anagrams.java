package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L49_Group_Anagrams {
    /*
     * Group Anagrams
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> st = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0;i < strs.length;i++){
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String sortedArray = new String(temp);

            if(map.containsKey(sortedArray)){
                map.get(sortedArray).add(strs[i]);
            }else{
                List<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(sortedArray, s);
            }
        }
        st.addAll(map.values());
        return st;
    }

    public static void main(String[] args) {
        
    }
}
