package gitDSALGO.leetcode;

public class O1_String_Compression {
    /*
     * String compression 
     */

    // public String StringCompression(String str){
    //     int left = 0;
    //     int right = 0;
    //     int counter = 0;
    //     String returnString = "";
    //     while(right<str.length()){
    //         if(str.charAt(left) == str.charAt(right)){
    //             counter++;
    //         }else{
    //             if(counter==1){
    //                 returnString+= str.charAt(left);
    //             }else{
    //                 returnString+= str.charAt(left);
    //                 returnString+= counter;
    //             }

    //             left = right;
    //         }
    //         right++;
    //     }
    //     return returnString;
    // }

    /*
     * Implement a method which performs basic string compression by counting sequences of repeating characters. Given "AABBBCCCD" it should return "A2B3C3D1". 
     */
    public String StringCompression(String str){
        StringBuilder st = new StringBuilder();
        int counter = 1;
        for( int i = 0; i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                counter++;
            }else{
                st.append(str.charAt(i));
                st.append(counter);
                counter=1;
            }
        }
        st.append(str.charAt(str.length()-1));
        st.append(counter);
        return st.toString();
    }
}
