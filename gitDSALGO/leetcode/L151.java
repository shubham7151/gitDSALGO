package gitDSALGO.leetcode;

public class L151 {
    
    /*
     * Reverse Words in a String
     */

     public String reverseWords(String s) {
        String trimString = s.trim();
        trimString = s.replaceAll(" +","#");
        String[] arr = trimString.split("#");
        String returnString = "";
        for(int i = arr.length-1; i>=0 ; i--){
            returnString+=arr[i]+" ";
        }
        return returnString.trim();
        // return trimString;
    }
    public static void main(String[] args) {
        
    }
}
