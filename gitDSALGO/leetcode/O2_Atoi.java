package gitDSALGO.leetcode;

public class O2_Atoi {
    
    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
        Read in and ignore any leading whitespace. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present. 
        Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1. 
        Return the integer as the final result.
     */

    public int myAtoi(String s){
            s = s.trim();
            if(s.length()==0){
                return 0;
            }
            int i = 0;
            int res = 0;
            boolean isPositive = true;
            if(s.charAt(i) == '-'){
                isPositive = false;
                i++;
            }else if(s.charAt(i) == '+'){
                i++;
            }
    
            while(i< s.length() && Character.isDigit(s.charAt(i))){
    
                int digit = s.charAt(i) - '0';
    
                if(res > (Integer.MAX_VALUE - digit) /10 ){
                    return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
    
                res = res * 10 + digit;
                i++;
            }
            return isPositive ? res : -1 * res;
         
        
    }
}
