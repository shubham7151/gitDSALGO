package gitDSALGO.leetcode;

public class O14_Power_Of_Ten {
    
    /*
     * Given an integer, find out whether it is a power of 10 or not.
     */

    public static boolean powerOfTen(int n){
        while(n!=1){
            if(n%10!=0){
                return false;
            }
            n=n/10;
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(powerOfTen(1000000000));
    }
}
