package gitDSALGO.leetcode;

public class L557_Reverse_Words_in_a_String_III {
    
    /*
     * Reverse Words in a String III
     */

     public String reverseWords(String s) {
        String[] st = s.split(" ");
        for( int i =0; i<st.length;i++){
            st[i] = reverse(st[i]);
        }
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i<st.length;i++){
            sb.append(st[i]);
            sb.append(" ");
        }
        sb.delete(sb.length()-1,sb.length());
        return sb.toString();
    }
    public String reverse(String t){
        StringBuilder sb = new StringBuilder(t);
        return sb.reverse().toString();

    }
}
