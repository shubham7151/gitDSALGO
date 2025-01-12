package gitDSALGO.leetcode;

import java.util.HashMap;

public class L166_Fraction_to_Recurring_Decimal {
    /*
     * Fraction to Recurring Decimal
     */

    public static String fractionToDecimal(int numerator, int denominator){
        // heck sign
        // take integer part 
        // add decimal
        // hashmap to check for reoccurence

        StringBuilder sb = new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)){
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        sb.append(num/den);
        long rem = num % den;
        if( rem == 0){
            // no fraction part 
            return sb.toString();
        }
        sb.append(".");

        HashMap<Long, Integer> hs = new HashMap<>();
        while(rem!=0){
            // check for recurrence
            if(hs.containsKey(rem)){
                sb.insert(hs.get(rem), "(");
                sb.append(")");
                break;
            }
            // REMEMBER TO UPDATE HASHMAP
            hs.put(rem, sb.length());
            rem = rem * 10;
            sb.append(rem/den);
            rem = rem % den;
        }

        return sb.toString();
    }
}
