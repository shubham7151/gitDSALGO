package gitDSALGO.leetcode;

public class L326_Power_of_Three {
    /*
     * Power of Three
     */

    /*
     * here you can divide the number by 3 till you get 1. in case anytime its not divisible by 3 return false;
     */

    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        // if(n == 1) return true;
        if(n!=1){
            if(n%3!=0) return false;
            n=n/3;
        }
        return n==1;
    }
}
