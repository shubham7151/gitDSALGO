package gitDSALGO.leetcode;

public class L1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    
    /*
     * Minimum Length of String After Deleting Similar Ends
     */

     public int minimumLength(String s) {
        /*
            aabccabba
            ^       ^
            while(equal) 
            increamemnt left till not equal
            decrement right till not equal
            right-left+1;

            b
        */
        if(s.length()==1){
            return 1;
        }
        int l = 0;
        int r = s.length()-1;
        while( l <r && s.charAt(l) == s.charAt(r)){
            // increment till not same
            char same = s.charAt(l);
            while(l<=r && s.charAt(l)== same)l++;
            while(r>=l && s.charAt(r)== same)r--;
            // System.out.println("=>"+s.substring(l,r+1));
        }
        // System.out.println(r);
        // System.out.println(l);
        return  r-l+1;
    }
}
