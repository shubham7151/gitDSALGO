import java.util.*;
public class Local {
    /*
     *     24 print the highest substring length and index value. 
            1.1 EX: AAABBBBBBBBCCVV
            1.2 Output: B 8
     */

    public static void highSubStr(String s){
        int start = 0;
        int end = 0;
        int locallength = 0;
        int maxLength = 0;
        char ch = '\0';
        int i = 0;
        int j = 1;
        while( j < s.length()){
            if(s.charAt(j)!= s.charAt(j-1)){
                locallength = j-i;
                if( locallength > maxLength){
                    maxLength = locallength;
                    start = i;
                    end = j;
                    ch = s.charAt(j-1);
                }
                i = j;
            }
            j++;

        }

        locallength = j-i;
        if( locallength > maxLength){
            maxLength = locallength;
            start = i;
            end = j;
            ch = s.charAt(j-1);
        }

        System.out.println(ch + "=" + maxLength + "=" + start + "=" + end);
    }
    /*
     *     23 char findFirst(String input)
            1.1   * Finds the first character that does not repeat anywhere in the input string
            1.2   * If all characters are repeated, return 0
            1.3   * Given "apple", the answer is "a"
            1.4   * Given "racecars", the answer is "e"
            1.5   * Given "ababdc", the answer is "d"
     */

    public static char findFirst(String input){
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for( int i = 0; i < input.length();i++){
            if( charFreq.containsKey(input.charAt(i))){
                charFreq.put(input.charAt(i), charFreq.get(input.charAt(i))+1);
            }else{
                charFreq.put(input.charAt(i), 1);
            }
        }

        for(int i = 0; i<input.length();i++){
            if(charFreq.get(input.charAt(i)) == 1){
                return input.charAt(i);
            }
        }
        return '1';
    }
    /*
     * Simple implementation of Reversing each word in String. 
        Conditions : 
        1. Retain the case of the alphabet at particular Index.# 
        Example: 
        Input - I am Robot 
        Output - I ma Tobor 
        2. The special characters should retain the position. 
        Example: 
        Input - I am, Robot! 
        Output - I ma, Tobor! 
     */

    public static String reverseWithCondition(String s){
        
        char[] temp = s.toCharArray();
        int i = 0;
        int j = temp.length-1;
        while(i<j){
            if(!Character.isAlphabetic(temp[i])){
                i++;
            }else if (!Character.isAlphabetic(temp[j])){
                j--;
            }else{
                if(Character.isUpperCase(temp[i]) && Character.isLowerCase(temp[j])){
                    char x = temp[i];
                    temp[i] = Character.toUpperCase(temp[j]);
                    temp[j] = Character.toLowerCase(x);
                }else if(Character.isUpperCase(temp[j]) && Character.isLowerCase(temp[j])){
                    char x = temp[j];
                    temp[j] = Character.toUpperCase(temp[i]);
                    temp[i] = Character.toLowerCase(x);
                }else{
                    char x = temp[i];
                    temp[i] = temp [j];
                    temp[j] = x; 
                }
                i++;
                j--;
            }
        }

        return new String(temp);
    }
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        String[] splitIntoArray = s.split(" ");
        return reverseWithCondition(s);
        // for(String t : splitIntoArray){
        //     sb.append(reverseWithCondition(t)).append(" ");
        // }
        // sb.setLength(sb.length()-1);
        // return sb.toString();
    }

    /*
     * Implement a function which returns a string representation of the decimal expansion of a fraction. This function should handle repeating parts by enclosing them in brackets as follows 
        1/2 -> "0.5" 
        1/3 -> "0.(3)" 
        22/7 -> "3.(142857)" 
        String fraction Expansion(long numerator, long denominator)
     */

     public static String decimal(long num, long den){
        // check sign
        // remove int
        // check for decimal
        // if decimal
        // long division
        StringBuilder str = new StringBuilder();
        if((num < 0 && den > 0)|| (num > 0 && den <0)){
            str.append('-');
        }
        
        Long rem = 0l;
        str.append(num/den);
        rem = num%den;
        if( rem==0){
            return str.toString();
        }
        str.append(".");
        HashMap<Long,Integer> recurringString = new HashMap<>();

        while(rem!=0){
            if(recurringString.containsKey(rem)){
                str.insert(recurringString.get(rem), "(");
                str.append(")");
                break;
            }
            recurringString.put(rem , str.length());
            rem = rem*10;
            str.append(rem/den);
            rem = rem % den;
        }

        return str.toString();
    }
    /*
     * Implement a function which calculates whether a number is a power of 10. 
        Boolean is PowerOfTen (int number)
     */

     public static boolean powerOfTen(int num){
        if(num<=0) return false;
        while(num>1){
            if(num%10 != 0) return false;
            num /= 10;
        }
        return true;
     }

     /*
      * Given a string str and an integer L. The task is to print all the unique substring of length L from string str.  
        Examples: Input: str = “abca”, L=3 
        Output: “abc”, “bca” Input: str = “aaaa”, L=3 
        Output: “aaa” 
        Example case : aab, length=2; result is aa, ab
      */

    public static void uniqueString(String s, int l){
        int i = 0;
        int j = l;
        List<String> st = new ArrayList<>();
        while(j<=s.length()){
            String subString = s.substring(i, j);
            if(!st.contains(subString)){
                st.add(subString);
            }
            i++;
            j++;
        }
        for(String t : st){
            System.out.println(t);
        }
    }

    /*
     * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1. 
        lengthOfCycle([1, 0], 0); // 2 
        lengthOfCycle([1, 2, 0], 0); // 3 
        lengthOfCycle([1, 2, 3, 1], 0); // 3 
     */

    public static int cyclicArray(int[] arr, int startInd){
        int steps = 0;
        int curr = startInd;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(curr>=0 && curr < arr.length){
            if(hm.containsKey(curr)){
                return steps - hm.get(curr);
            }
            hm.put(curr, steps);
            steps++;
            curr = arr[curr];
        }
        return -1;
    }

    /*
     * Train Station Map problem
     */

     /*
      * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
      */

    public static double median(int[] nums1, int[] nums2){
        int[] arr = new int[nums1.length+nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while( i <nums1.length && j < nums2.length){
            if(nums1[i] <  nums2[j]){
                arr[k] = nums1[i];
                k++;
                i++;
            }else if(nums2[j] < nums1[i]){
                arr[k] = nums2[j];
                j++;
                k++;
            }else{
                arr[k] = arr[i];
                i++;
                k++;
            }
        }

        while(i<nums1.length){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }

        double mid= 0l;
        if(arr.length%2==0){
            mid = (arr[arr.length/2] + arr[arr.length/2 -1])/2.0;
        }else{
            mid = arr[arr.length/2];
        }

        return mid;
    }

    /*
      * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

    public static int j(int n, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        for( int i = 0; i <n ; i++){
            arr.add(i+1);
        }
        int j = 0;
         while(arr.size()!=1){
            int removeIndex = (j+k-1)%arr.size();
            arr.remove(removeIndex);
            j = removeIndex;
         }
        return arr.get(0);
    }
    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
    Read in and ignore any leadin	g whitespace. 
    Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively.
     Assume the result is positive if neither is present. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 
    Return the integer as the final result.
     */

    public static int myAtoi(String s){
        s = s.trim();
        int i = 0;
        boolean isPositive = true;
        if(s.charAt(i)=='-'){
            isPositive = false;
            i++;
        }else if (s.charAt(i) == '+'){
            i++;
        }
        int res = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if( res > (Integer.MAX_VALUE-digit)/10){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res  = res *10;
            res = res+digit;
            i++;
        }

        return res;
    }

    /*
     * Implement a method which performs basic string compression by counting sequences of repeating characters. 
     * Given "AABBBCCCD" it should return "A2B3C3D1"
     */

    public static String compress( String s){
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for( int i = 1; i <s.length();i++){
            if(s.charAt(i)!= s.charAt(i-1)){
                sb.append(s.charAt(i-1));
                sb.append(counter);
                counter= 1;
            }else{
                counter++;
            }
        }
        sb.append(s.charAt(s.length()-1));
        sb.append(counter);
        return sb.toString();
    }

    /*
     * Problem Statement: 
        You are an avid rock collector who lives in southern California. Some rare 
        and desirable rocks just became available in New York, so you are planning 
        a cross-country road trip. There are several other rare rocks that you could 
        pick up along the way. 
        You have been given a grid filled with numbers, representing the number of 
        rare rocks available in various cities across the country. Your objective 
        is to find the optimal path from So_Cal to New_York that would allow you to 
        accumulate the most rocks along the way. 
        Note: You can only travel either north (up) or east (right). 
        2) Consider adding some additional tests in doTestsPass(). 
        3) Implement optimalPath() correctly. 
        4) Here is an example: 
        ^ 
                        {{0, 0, 0, 0, 5}, New_York (finish)     N 
                        {0, 1, 1, 1, 0},                    < W   E > 
        So_Cal (start) {2, 0, 0, 0, 0}}                         S 
        v 
        The total for this example would be 10 (2 + 0 + 1 + 1 + 1 + 0 + 5). 
        Signature: 
        public static Integer optimalPath(Integer[][] grid) { 
        } 
        Test Cases: 
        Input : 
        {{0, 0, 0, 0, 5}, 
        {0, 1, 1, 1, 0}, 
        {2, 0, 0, 0, 0}}; 
        Output: 10 
     */

    public static int optimalPath(int[][] grid){
        return optimalPath(grid,grid.length-1, 0);
    }
    public static int optimalPath(int[][] grid, int row, int col){
        // check out of boud 
        if(row<0 || col >= grid[0].length){
            return 0;
        }
        //if reached NYC return value
        if( row ==0 && col == grid[0].length-1){
            return grid[row][col];
        }

        int moveUp = optimalPath(grid, row-1, col);
        int moveRight = optimalPath(grid,row, col+1);

        // max of above two path and current value
        return grid[row][col] + Math.max(moveUp, moveRight);

    }

    // optimization by memorization
    public static int optimalPathMemo(int[][] grid){
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                memo[i][j] = -1;;
            }
        }

        return optimalPathMemo(grid,grid.length-1,0,memo);
    }

    public static int optimalPathMemo(int[][] grid, int row, int col, int[][] memo){
        if( row< 0 || col >= grid[0].length){
            return 0;
        }
        // reached return
        if(row == 0 && col == grid[0].length-1){
            return grid[row][col];
        }
        if(memo[row][col]!=-1){
            return memo[row][col];
        }
        int moveUp = optimalPathMemo(grid,row-1,col,memo);
        int moveDown = optimalPathMemo(grid,row,col+1,memo);

        memo[row][col] = grid[row][col]+ Math.max(moveDown,moveUp);

        return memo[row][col];
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };

        System.out.println(optimalPathMemo(grid));
    }
}
