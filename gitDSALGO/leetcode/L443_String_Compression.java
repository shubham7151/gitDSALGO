package gitDSALGO.leetcode;

public class L443_String_Compression {

    /*
     * String Compression
     */

     public int compress(char[] chars) {
        int ind = 0;
        int left = 0;
        int right = 0;

        while(right<chars.length){
        char character = chars[left];

            while(right < chars.length && chars[left] == chars[right]){
                right++;
            }
            chars[ind]= character;
            ind++;
            
            int size = right-left;
            if(size >1){
                for(char c : String.valueOf(size).toCharArray()){
                    chars[ind]=c;
                    ind++;
                }
            }
            left = right;
        }
        
        return ind;
    }
    
}