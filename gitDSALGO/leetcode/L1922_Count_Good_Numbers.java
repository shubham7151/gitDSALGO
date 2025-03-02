package gitDSALGO.leetcode;

public class L1922_Count_Good_Numbers {
    
    /*
     * Count Good Numbers
     */

     class Solution {
        int mod = (int)1e9+7;
        public int countGoodNumbers(long n) {
            /*
            the intution behind this question is that 
            for even positiion index we have 5 posibuility i.e. 2,4,6,8,0
            for odd position index we have 4 possibility i.e. 2,3,5,7
    
            so let say we have n=2 so fo this we will have 5C1 * 4C1
    
            we can do this by divide and conque
    
            so we can check if n is odd or even
            if odd we will pow as n/2+1 and for even we will have n/2
    
            */
            
            long fivespow = n%2==0 ? n/2 : (n/2)+1;
            long fourpow = n/2;
    
            long evenpos =  pow(5,fivespow)%mod ;
            long oddpos =  pow(4, fourpow)%mod;
    
            long ans =1;
            ans = (ans*evenpos)%mod;
            ans = oddpos!=0 ? (ans*oddpos)%mod : ans;
    
            return (int) (ans%mod);
        }
    
        public long pow(long x, long n){
            if(n==0) return 1;
    
            long temp = pow(x,n/2);
    
            if(n%2==0){
                return (temp * temp) % mod;
            }else{
                return (x * temp * temp)%mod;
            }
        }
    }
}
