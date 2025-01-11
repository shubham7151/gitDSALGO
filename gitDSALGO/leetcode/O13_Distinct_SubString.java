package gitDSALGO.leetcode;

import java.util.HashSet;
import java.util.List;

public class O13_Distinct_SubString {
    /*
     * Given a string str and an integer L. The task is to print all the unique substring of length L from string str.
     * Examples: Input: str = “abca”, L=3 
        Output: “abc”, “bca” Input: str = “aaaa”, L=3 
        Output: “aaa” 
        Example case : aab, length=2; result is aa, ab 
     */

    public static Object[] distinctSubString(String s, int l){
        HashSet<String> set = new HashSet<>();
        int p = 0;
        int r = l;
        while(r<=s.length()){
            StringBuilder sb = new StringBuilder();
            for(int i = p; i<r;i++){
                sb.append(s.charAt(i));
            }
            set.add(sb.toString());
            p++;
            r++;
        }
        // System.out.println(set);
        return set.toArray();

    }
    public static void main(String[] args) {
        String s = "aabc";
        // System.out.println(distinctSubString(s,2));
        for(Object ss : distinctSubString(s, 3  )){
            System.out.println(ss);
        }
    }
}
