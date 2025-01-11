package gitDSALGO.leetcode;

public class O15_Reverse_String_With_Condition {
    
    /*
     * Simple implementation of Reversing each word in String. 
Conditions : 
1. Retain the case of the alphabet at particular Index.# 
Example: 
Input - I am Robot 
Output - I ma Tobor 
2. The special characters should retain the position. 
Example: 
Input - I am, Robot! 
Output - I ma, Tobor!
     */

    public static String reverseString(String s){
        String[] t = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for( String st : t){
            sb.append(rev(st)).append(" ");
        }
        return sb.toString();
    }

    public static String rev(String s){
        char[] t = s.toCharArray();
        int l = 0, r = s.length()-1;
        while(l<r){
            if(!Character.isAlphabetic(t[l])){
                l++;
            }
            else if(!Character.isAlphabetic(t[r])){
                r--;
            }else{
                Character temp = t[l];
                t[l] = t[r];
                t[r]= temp;
                l++;
                r--;
            }

        }

        return new String(t);
    }

    public static void main(String[] args) {
        String input = "I am, Robot!";
        String output = reverseString(input);
        System.out.println(output);
    }
}
