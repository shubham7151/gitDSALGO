package gitDSALGO.Concepts;

import java.util.ArrayList;

public class Permutation {
    
    /*
     * print all permutation of the word
     */

    static void permutations(String p , String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for( int i = 0; i<=p.length();i++){
            String f = p.substring(0,i);
            String sec = p.substring(i);

            permutations(f+ch+sec, up.substring(1));
        }
    }

    /*
     * return all permutation of the string 
     */

    static ArrayList<String> permutationsReturn(String p , String up){
        if(up.isEmpty()){
        ArrayList<String> t = new ArrayList<>();
        t.add(p);
        return t ;
        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();


        for( int i = 0; i<=p.length();i++){
            String f = p.substring(0,i);
            String sec = p.substring(i);

            ans.addAll( permutationsReturn(f+ch+sec, up.substring(1)) );

        }

        return ans;
    }

    /*
     * Generate all binary strings without consecutive 1’s
     */


    static void generateBinaryStringHelper(int n, String s, int i){
        /*
         *  the basic idea is when we have empty string its like for a space how many inputs are possible 
         * add all inputs then if 0 invoke for 1 and 0 and if its 1 invoke for 0
         */
        if(n==i){
            System.out.println(s);
            return;
        }

        if(i==0){
            generateBinaryStringHelper(n,s+'1',i+1);
            generateBinaryStringHelper(n,s+'0',i+1);
        }
        else{
            if(s.charAt(i-1)=='0'){
                generateBinaryStringHelper(n,s+'1',i+1);
                generateBinaryStringHelper(n,s+'0',i+1);
            }
            else{
                generateBinaryStringHelper(n,s+'0',i+1);
            }
        }

    }
    public static void main(String[] args) {
        generateBinaryStringHelper(3,"",0);
    }
}
