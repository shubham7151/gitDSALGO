package gitDSALGO.leetcode;

import java.util.HashSet;

public class L202_Happy_Number {
    /*
     * Happy Number
     */

    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();

        while(n!=1){
            if(hs.contains(n)){
                return false;
            }
            hs.add(n);
            n = sumOfSquareOfDigits(n);
        }
        return true;
    }

    public int sumOfSquareOfDigits(int num){
        int sum = 0;
        while(num>0){
            int temp = num%10;
            sum += temp*temp;
            num = num/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        
    }
}
