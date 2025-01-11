package gitDSALGO.leetcode;

public class O8_Extract_Number_from_String {
    /*
     * Input may contain letters symbols and any character but return only the numbers as an integer (Asked the time complexity of the code, and if there is a way to improve it if that is not optimal, asked to write extra test cases)
     */

    public static int extractNumber(String s){
        int res = 0;
        for( int i =0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                res = res*10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "123sadsaoi213";
        System.out.println(extractNumber(s));
    }
}

