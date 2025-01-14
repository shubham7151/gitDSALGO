package gitDSALGO.leetcode;

import java.util.HashSet;

public class L1249_Minimum_Remove_to_Make_Valid_Parentheses {
    /*
     * Minimum Remove to Make Valid Parentheses
     */

     public String minRemoveToMakeValid(String s) {
        // initilize stack
        // iterate through arr if char is letter ignore 
        // remove balanced paranthesis
        //if its ( push i else non empty and charat(peek) == (
        // build string 
        Stack<Integer> st = new Stack<>();
        for( int i = 0; i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)){
                continue;
            }
            if(ch == '('){
                st.push(i);
            }else{
                if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }
         StringBuilder sb = new StringBuilder();
        HashSet<Integer> hs = new HashSet<>(st);
            for( int i = 0; i<s.length(); i++){
                if(!hs.contains(i)){
                    sb.append(s.charAt(i));
                }
            }
        return sb.toString();
    }
}
