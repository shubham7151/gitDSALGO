package gitDSALGO.leetcode;

public class O17_Highest_Substring_length {
    
    /*
     *     24. Return the highest substring length and index value. 
            1. EX: AAABBBBBBBBCCVV
            2. Output: B 8
     */

    public static String highestSubString(String s){
        int i =0, j= 1;
        char[] chars = s.toCharArray();
        char res = chars[i];
        int len = 0;
        int maxlen = 0;
        int start = 0;
        int end = 0;
        while(j<chars.length){
            if(chars[j]!=chars[j-1]){
                len = j-i;
                if( maxlen<len){
                    res = chars[j-1];
                    maxlen = len;
                    start = i;
                    end = j;
                }
                i=j;
            }
            j++;
        }

        len = j-i;
        if( maxlen<len){
            res = chars[j-1];
            maxlen = len;
            start = i;
            end = j;
        }
        return String.valueOf(res) + "->" + maxlen + "Start=>" + start+ "end=>"+end;
    }

    public static void main(String[] args) {
        String s = "AAABBBBBBBBCCVV";
        System.out.println(highestSubString(s));
    }
}

