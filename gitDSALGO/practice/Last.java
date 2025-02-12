import java.util.*;

import javax.print.DocFlavor.STRING;
public class Last {
    
    /*
     * Implement a method which performs basic string compression by counting sequences of repeating characters. 
     * Given "AABBBCCCD" it should return "A2B3C3D1"
     */

     /*
      * time = 0(n)
        space = o(n)
      */
    public static String compressString(String s){
        if(s.length()==0){
            return "";
        }
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for( int i = 1; i<s.length();i++){
            if(s.charAt(i)!= s.charAt(i-1)){
                sb.append(s.charAt(i-1));
                // System.out.println(counter);
                if(counter>1){
                    sb.append(counter);
                }
                counter=1;
            }else{
                counter++;
            }
        }

        sb.append(s.charAt(s.length()-1));
        if(counter>1){
            sb.append(counter);
        }

        return sb.toString();
    }
    

    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
        Read in and ignore any leadin	g whitespace. 
        Check if the next character (if not already at the end of the string) is '-' or '+'. 
        Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present. 
        Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). 
        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 
        Return the integer as the final result.
     */

    public static int myAtoi(String s){
        s = s.trim();
        int i = 0;
        boolean isPositive = true;
        if(s.charAt(i) == '-'){
            isPositive = false;
            i++;
        }else if(s.charAt(i) ==  '+'){
            i++;
        }
        int res = 0;
        while( i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if(res > (Integer.MAX_VALUE - digit)/10){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res *10;
            res += digit;
            i++;
        }       
        return isPositive ? res : res*-1;  
    }
    /*
     * Given a string replace the largest repeated substring at every point with an asterisk(*). The goal is end result should be a minimal length string after compression
        For example, s = "abcabcd" should become "abc*d", Reason: we know abc has repeated twice, so replace the entire second instance of abc with an *.
        and if s = "aabbaabb" it should become "a*bb*", Reason: At index 1, a is repeated twice so put an * there, and aabb has repeated twice so replace it's second instance with an *. 
        In this example we don't put an * right after b at index 3 because aab* would represent aabaab, but that isn't the case.
     */

    public static String her(String s, int i, StringBuilder encoded){

        if(i>=s.length()){
            return encoded.toString();
        }
        if(i!=0 && i*2 <= s.length()){
            String comp = s.substring(0, i);
            if(comp.equals(s.substring(i, 2*i))){
                encoded.append("*");
                String res1 = her(s, i*2, new StringBuilder(encoded.toString()));
                // System.out.println(res1);
                encoded.setLength(encoded.length()-1);
                encoded.append(s.charAt(i));
                String  res2 = her(s, i+1, new StringBuilder(encoded.toString()));
                // System.out.println(res2);
                return res1.length() < res2.length() ? res1 : res2;
            }
        }
        encoded.append(s.charAt(i));
        return her(s, i+1, new StringBuilder(encoded.toString()));
    }   
    public static int hermioneString(String s){
        String encodedString = her(s,0,new StringBuilder());
        System.out.println(encodedString);
        return encodedString.length();
    }

    /*
     * Find the missing alphabets from a panagram
     */

    public static String missingAlphabet(String s){
        // hashmap to keep character frequencey
        HashMap<Character, Integer>  charFreq = new HashMap<>();
        String ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
        for(char ch : ALPHABET.toCharArray()){
            charFreq.put(ch, 0);
        }
        // counter frequ of character
        for(char ch : s.toLowerCase().toCharArray()){
            if(charFreq.containsKey(ch)){
                charFreq.put(ch, charFreq.get(ch)+1);
            }
        }
        // create string with alpha not there
        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character, Integer> t : charFreq.entrySet()){
            if(t.getValue()==0){
                res.append(t.getKey());
            }
        }

        return res.toString();
    }
    /*
    *  Find the best avg grade of a student
     * Find maximum average mark student's name 
        {{“Charles”, 84}, 
        {“John”, 100}, 
        {“Andy”, 67}, 
        {“John”, 22}} 
        O/P : Charles - 84 
     */

    public static String bestAvg(String[][] input){
        HashMap<String, List<Integer>> stdScore = new HashMap<>();
        for( int i =0; i<input.length; i++){
            String name = input[i][0];
            int score = Integer.parseInt(input[i][1]);
            if(stdScore.containsKey(name)){
                stdScore.get(name).add(score);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(score);
                stdScore.put(name, temp);
            }
        }
        // calculate max avg name
        StringBuilder maxStudentName = new StringBuilder();
        int max = 0;
        for(Map.Entry<String, List<Integer>> t : stdScore.entrySet()){
            int sum = t.getValue().stream()
            .mapToInt(i->i)
            .sum();
            int avg = sum/t.getValue().size();
            if(avg > max){
                max = avg;
                maxStudentName = new StringBuilder(t.getKey());
            }
        }
        return maxStudentName.append(" grade -> ").append(max).toString();
    }

    /*
     * Find the second largest number in the array 
        e.g. [2,5,6,8] 
        O/P : 6 
     */

    public static int secondLargest(int[] arr){
        int large = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;
        for( int i : arr){
            if(i > largest){
                large = largest;
                largest = i;
            }else if(i > large && i != largest){
                large = i;
            }
        }
        return large;
    }
    /*
     * Write a pgm to find the second smallest number.
     */
    public static int secondSmallest(int[] arr){
        int small = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for( int i : arr){
            if(i < smallest){
                small = smallest;
                smallest = i;
            }else if(i < small && i != smallest){
                small = i;
            }
        }
        return small;
    }
    /*
     * Input may contain letters symbols and any character but return only the numbers as an integer (Asked the time complexity of the code, 
     * and if there is a way to improve it if that is not optimal, asked to write extra test cases) 
     */

    public static int fetchInteger(String s){
        int res = 0;
        for(Character ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                int digit = ch-'0';
                res = res * 10;
                res = res + digit;

            }
        }

        return res;
    }
    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
        There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
        For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
        If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

    public static int josephus(int n , int k){
        List<Integer> arr = new ArrayList<>();
        for( int i = 0; i<n;i++){
            arr.add(i+1);
        }
        int j = 0;
        while(arr.size()!=1){
            int removeInd = (j+k-1)%arr.size();
            arr.remove(removeInd);
            j = removeInd;
        }
        return arr.get(0);
    }
    public static int josephusO(int n, int k){
        int winner = 0;
        for( int i = 2; i<=n;i++){
            winner = (winner +k)%i;
        }
        return winner;
    }
    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     */
    public static double medianOfSortedArrays(int[] nums1, int[] nums2){
        int[] arr = new int[nums1.length+nums2.length];
        int i = 0,j = 0, k = 0;
        while( i< nums1.length && j <nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }else if(nums2[j] < nums1[i]){
                arr[k] = nums2[j];
                k++;
                j++;
            }else{
                arr[k] = nums1[i];
                i++;
                k++;
            }
        }
        while(i< nums1.length){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length){
            arr[k] = nums2[j];
            k++;
            j++;
        }
        double mid = 0;
        if(arr.length%2==0){
            mid = (arr[arr.length/2] + arr[arr.length/2-1])/2.0;
        }else{
            mid = arr[arr.length/2];
        }
        return mid;
    }

    /*
     * Find the mostly used IP Address (Apache Log Pattern) from String[] - 
     * Completed within 18 mins and covered all the test cases and added all the edged cases as well.
     */
    public static String mostFrequentIp(String[] logs){
        HashMap<String, Integer> logsFreq = new HashMap<>();
        for( String log : logs){
            String[] splitlogs = log.split("-");
            if(logsFreq.containsKey(splitlogs[0])){
                logsFreq.put(splitlogs[0], logsFreq.get(splitlogs[0])+1);
            }else{
                logsFreq.put(splitlogs[0], 1);
            }
        }
        int max = 0;
        StringBuilder maxFreqIp = new StringBuilder();

        for(Map.Entry<String, Integer> t : logsFreq.entrySet()){
            // System.out.println();
            if(t.getValue() > max){
                max = t.getValue();
                maxFreqIp = new StringBuilder(t.getKey());
            }
        }
        return maxFreqIp.toString();
    }
    /*
     * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1. 
        lengthOfCycle([1, 0], 0); // 2 
        lengthOfCycle([1, 2, 0], 0); // 3 
        lengthOfCycle([1, 2, 3, 1], 0); // 3 
     */

    public static int cyclicArray(int[] arr, int startInd){
        HashMap<Integer, Integer> stepCounter = new HashMap<>();
        int curr  = startInd;
        int steps = 0;
        while(curr>=0 && curr <arr.length){
            if(stepCounter.containsKey(curr)){
                return steps - stepCounter.get(curr);
            }
            stepCounter.put(curr, steps);
            curr = arr[curr];
            steps++;
        }
        return -1;
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
        {{0, 0, 0, 0, 5}, New_York (finish) N 
        {0, 1, 1, 1, 0}, < W E > 
        So_Cal (start) {2, 0, 0, 0, 0}} S 
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

    public static int optimalPath(int[][] grid, int row, int col){
        // out of bound
        if(row < 0 || col >= grid[0].length){
            return 0;
        }
        // if we reach nYC
        if(row == 0 && col == grid[0].length-1){
            return grid[row][col];
        }

        int moveUp = optimalPath(grid, row-1, col);
        int moveRight = optimalPath(grid, row, col+1);
        // System.out.println(moveUp);
        return grid[row][col] + Math.max(moveUp, moveRight);
    }
    public static int optimalPath(int[][ ]grid){
        return optimalPath(grid, grid.length-1, 0);
    }

    /*
     * Given a string str and an integer L. The task is to print all the unique substring of length L from string str.  
        Examples: Input: str = “abca”, L=3 
        Output: “abc”, “bca” Input: str = “aaaa”, L=3 
        Output: “aaa” 
        Example case : aab, length=2; result is aa, ab
     */

    public static List<String> uniqueSubstring(String s, int l){
        List<String> uniqueString = new ArrayList<>();
        int i =0;
        int j = l;
        while(j<=s.length()){
            String subStr = s.substring(i, j);
            if(!uniqueString.contains(subStr)){
                uniqueString.add(subStr);
            }
            i++;
            j++;
        }
        return uniqueString;
    }
    /*
     * Implement a function which calculates whether a number is a power of 10. 
        Boolean is PowerOfTen 
     */
    public static boolean powerOften(int n){
        if(n<=0)return false;
        while(n>1){
            if(n%10!=0) return false;
            System.out.println(n);
            n = n/10;
        }
        return true;
    }
    /*
     * Implement a function which returns a string representation of the decimal expansion of a fraction. This function should handle repeating parts by enclosing them in brackets as follows 
        1/2 -> "0.5" 
        1/3 -> "0.(3)" 
        22/7 -> "3.(142857)" 
        String fraction Expansion(long numerator, long denominator)                                                                   
     */
    public static String expansion(long numerator, long denominator){
        // check for sigbn 
        // remove int
        // add decimal
        // check for recurive part and long division 
        // boolean isPositive = true;
        StringBuilder expand = new StringBuilder();
        if(numerator <0 && denominator > 0 || numerator >0 && denominator <0){
            expand.append("-");
        }
        long num = Math.abs(numerator);
        long den = Math.abs(denominator);

        
        expand.append(num/den);
        long rem = num%den;
        if(rem==0){
            return expand.toString();
        }
        expand.append(".");
        HashMap<Long, Integer> checkRecurence = new HashMap<>();
        while(rem!=0){
            if(checkRecurence.containsKey(rem)){
                expand.insert(checkRecurence.get(rem), "(");
                expand.append(")");
                // System.out.println(expand);
                break;
            }
            checkRecurence.put(rem, expand.length());
            rem = rem*10;
            expand.append(rem/den);
            rem = rem % den;
        }
        return  expand.toString();
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
        // hashmap to have char frequencey
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for(char ch : input.toCharArray()){
            if(charFreq.containsKey(ch)){
                charFreq.put(ch, charFreq.get(ch)+1);
            }else{
                charFreq.put(ch, 1);
            }
        }
        for(int i = 0; i<input.length();i++){
            if(charFreq.get(input.charAt(i)) ==1){
                return input.charAt(i);
            }
        }
        return '0';
    }

    /*
     *     24 Return the highest substring length and index value. 
            1.1 EX: AAABBBBBBBBCCVV
            1.2 Output: B 8
     */

    public static int[] highestSubString(String s){
        if(s.length()==0){
            return new int[]{-1,-1};
        }
        int start = 0;
        int i = 0;
        int j = 1;
        int localLength = 0;
        int maxLength = 0;
        while(j<s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                localLength = j-i;
                if(maxLength < localLength){
                    maxLength = localLength;
                    start = i;
                }
                i=j;
            }
            j++;
        }
        localLength = j-i;
        if(localLength > maxLength){
            maxLength = localLength;
            start = i;
        }
        return new int[]{start, maxLength};
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

    public static String reverseWithCond(String s){
        int i = 0;
        int j = s.length()-1;
        char[] toCharArr = s.toCharArray();
        while(i<j){
            if(!Character.isAlphabetic(toCharArr[i])){
                i++;
            }else if(!Character.isAlphabetic(toCharArr[j])){
                j--;
            }else{
                if(Character.isUpperCase(toCharArr[i]) && Character.isLowerCase(toCharArr[j])){
                    char x = toCharArr[i];
                    toCharArr[i] = Character.toUpperCase(toCharArr[j]);
                    toCharArr[j] = Character.toLowerCase(x);
                }else if(Character.isUpperCase(toCharArr[j]) && Character.isLowerCase(toCharArr[i])){
                    char x = toCharArr[i];
                    toCharArr[i] = Character.toLowerCase(toCharArr[j]);
                    toCharArr[j] = Character.toUpperCase(x);
                }else{
                    char x = toCharArr[i];
                    toCharArr[i] = toCharArr[j];
                    toCharArr[j] = x;
                }
                i++;
                j--;
            }
        }

        return new String(toCharArr);
    }

    public static String reverse(String s){
        String[] splitStr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String st : splitStr){
            sb.append(reverseWithCond(st)).append(" ");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
      
       System.out.println(reverse("Ab"));
    }

}
