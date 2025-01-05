package gitDSALGO.leetcode;

public class L50_Pow{
    
    /*
     * Pow(x, n)
     */

    public int myPow(int x , int n){
        if(n == 0){
            return 1;
        }
        if(n<0){
            n = -n;
            x = 1/x;
        }

        if(n%2 == 0){
            return myPow(x*x, n/2);
        }else{
            return x*  myPow(x, n-1);
        }
    }
}
