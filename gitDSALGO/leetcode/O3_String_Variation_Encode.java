package gitDSALGO.leetcode;

public class O3_String_Variation_Encode {
    /*
     * Hermione is preparing a cheat-sheet for her final exam in Potions class. 
    To create a potion, one must combine ingredients in a specific order, any of which may be repeated. 
    As an example, consider the following potion which uses 4 distinct ingredients 
    (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D.  
    Hermione realizes she can save tremendous space on her cheat-sheet by introducing a 
    special instruction, '*', which means "repeat from the beginning". 
    Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D 
     */

    public static String encoded(String s, int i, StringBuilder encodedString){
        if(i>=s.length()){
            return encodedString.toString();
        }
        if(i!=0 && i*2 <= s.length()){
            String cmp = s.substring(0, i);
            if(cmp.equals(s.substring(i, i*2))){
                encodedString.append("*");
                String r1 = encoded(s, i*2, new StringBuilder(encodedString.toString()));
                encodedString.setLength(encodedString.length()-1);
                encodedString.append(s.charAt(i));
                String r2 = encoded(s, i+1, new StringBuilder(encodedString.toString()));
                return r1.length() < r2.length() ? r1 : r2;
            }
        }
        encodedString.append(s.charAt(i));
        return encoded(s, i+1, new StringBuilder(encodedString));
    }
    public static int endode(String s){
        String ss =  encoded(s, 0, new StringBuilder());
        System.out.println(ss);
        return ss.length();
    }

    public static void main(String[] args) {
        System.out.println(endode("abcabcd"));
    }
}
