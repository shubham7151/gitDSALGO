package gitDSALGO.leetcode;

public class L8_String_to_Integer_atoi {
    
    /*
     * String to Integer (atoi)
     * 
     */

    public int myAtoi(String s) {
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
