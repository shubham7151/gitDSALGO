package gitDSALGO.leetcode;

public class O1_String_Compression {
    /*
     * String compression 
     */

    public String StringCompression(String str){
        int left = 0;
        int right = 0;
        int counter = 0;
        String returnString = "";
        while(right<str.length()){
            if(str.charAt(left) == str.charAt(right)){
                counter++;
            }else{
                if(counter==1){
                    returnString+= str.charAt(left);
                }else{
                    returnString+= str.charAt(left);
                    returnString+= counter;
                }

                left = right;
            }
            right++;
        }
        return returnString;
    }
}
