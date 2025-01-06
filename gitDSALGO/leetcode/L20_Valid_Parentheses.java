package gitDSALGO.leetcode;

import java.util.*;
public class L20_Valid_Parentheses {
    
    /*
     * Valid Parentheses
     */

     public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if(s.length() < 2){
            return false;
        }
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else {
                if(!st.isEmpty() && ( s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' )){
                        char temp = st.pop();
                        if((temp == '{' && s.charAt(i) != '}') ||
                        (temp == '(' && s.charAt(i) != ')') ||
                        (temp == '[' && s.charAt(i) != ']')) {
                            return false;
                        }
                }else{
                    return false;
                }
            }
        }

        

        return st.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        
    }
}
