
import java.util.*;
public class LocalP {
    /*
     * Implement a method which performs basic string compression by counting sequences of repeating characters. 
     * Given "AABBBCCCD" it should return "A2B3C3D1".
     */

    public static String stringCompress(String s){
        if(s.length()==0){
            return "";
        }
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        for( int i = 1; i<s.length();i++){
            if(s.charAt(i)!= s.charAt(i-1)){
                sb.append(s.charAt(i-1));
                sb.append(counter);
                counter=1;
            }else{
                counter++;
            }
        }

        sb.append(s.charAt(s.length()-1));
        sb.append(counter);
        return sb.toString();
    }
    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
        Read in and ignore any leadin	g whitespace. 
        Check if the next character (if not already at the end of the string) is '-' or '+'. 
        Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present. 
        Read in next the characters until the next non-digit character or the end of the input is reached. 
        The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
        If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 
        Return the integer as the final result
     */

    public static int myAtoi(String s){
        s = s.trim();
        int i = 0;
        boolean isPositive = true;
        if(s.charAt(i)== '-') {
            isPositive= false;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
        int res = 0;
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            if(res > (Integer.MAX_VALUE - digit) / 10){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res *10;
            res += digit;
            i++;
        }

        return isPositive ? res : res*-1;
    }
    /*
     * Hermione is preparing a cheat-sheet for her final exam in Potions class. 
        To create a potion, one must combine ingredients in a specific order, any of which may be repeated. 
        As an example, consider the following potion which uses 4 distinct ingredients 
        (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D.  
        Hermione realizes she can save tremendous space on her cheat-sheet by introducing a 
        special instruction, '*', which means "repeat from the beginning". 
        Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D
     */

    public static String hermioneString(String s, int i , StringBuilder encoding){
        if(i >= s.length()){
            return encoding.toString();
        }
        if(i!=0 && i*2 <= s.length()){
            String comp = s.substring(0, i);
            if(comp.equals(s.substring(i, i*2))){
                encoding.append("*");
                String res1 = hermioneString(s, i*2, new StringBuilder(encoding.toString()));
                
                encoding.setLength(encoding.length()-1);
                encoding.append(s.charAt(i));
                String res2 = hermioneString(s, i+1, new StringBuilder(encoding.toString()));
                // System.out.println(res2);
                return res1.length() < res2.length() ?  res1 : res2;
            }
        }
        encoding.append(s.charAt(i));
        return hermioneString(s, i+1, new StringBuilder(encoding));
    }
    public static int hermioneString(String s){
        String res = hermioneString(s,0,new StringBuilder());
        System.out.println(res);
        return res.length();
    }

    /*
     * Find the missing alphabets from a panagram
     */

    public static String missingAlphabet(String s){
        s = s.toLowerCase();
        String ALPHABET = "qwertyuiopasdfghjklzxcvbnm";
        HashMap<Character, Integer> charFreq = new HashMap<>();
        for(char ch  : ALPHABET.toCharArray()){
            charFreq.put(ch, 0);
        }
        for(char ch : s.toCharArray()){
            if(charFreq.containsKey(ch)){
                charFreq.put(ch, charFreq.get(ch)+1);
            }
        }
        StringBuilder missingChar = new StringBuilder();
        for(Map.Entry<Character, Integer> temp : charFreq.entrySet()){
            if(temp.getValue()==0){
                missingChar.append(temp.getKey());
            }
        }

        return missingChar.toString();
    }

    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives.
     */

     public static int winnerCircle(int n, int k){
        // ArrayList<Integer> arr = new ArrayList<>();
        // for( int i = 0; i<n;i++){
        //     arr.add(i+1);
        // }
        // int j = 0;
        // while(arr.size()!=1){
        //     int removePosition = (j+k-1)%arr.size();
        //     arr.remove(removePosition);
        //     j = removePosition;
        // }

        // return arr.get(0);
        int winner = 0;
        for( int i = 2 ; i<= n;i++){
            winner=(winner+k)%i;
        }
        return winner+1;
    }

    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. 
     * The overall run time complexity should be O(log (m+n))
     */

    public static int medianOfSortedArrays(int[] num1, int[] num2){
        int[] arr = new int[num1.length+num2.length];
        int i =0,j=0,k=0;
        while(i<num1.length && j <num2.length){
            if(num1[i] < num2[j]){
                arr[k] = num1[i];
                i++;
                k++;
            }else if(num2[j] < num1[i]){
                arr[k] = num2[j];
                k++;
                j++;
            }else{
                arr[k] = num1[i];
                i++;
                k++;
            }
        }

        while(i<num1.length){
            arr[k] = num1[i];
            i++;
            k++;
        }
        while(j<num2.length){
            arr[k] = num2[j];
            j++;
            k++;
        }
        int mid = 0;
        if(arr.length%2==0){
            mid = (arr[arr.length/2] + arr[arr.length/2-1])/2;
        }else{
            mid = arr[arr.length/2];
        }
        return mid;
    }
    /*
     * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1. 
        lengthOfCycle([1, 0], 0); // 2 
        lengthOfCycle([1, 2, 0], 0); // 3 
        lengthOfCycle([1, 2, 3, 1], 0); // 3 
     */

    public static int cycleArray(int[] n, int start){
        HashMap<Integer, Integer> visited = new HashMap<>();
        int steps = 0;
        int curr = start;
        while( curr > 0 && curr < n.length){
            if(visited.containsKey(curr)){
                return steps - visited.get(curr);
            }
            visited.put(curr, steps);
            steps++;
            curr = n[curr];
        }

        return -1;
    }

    /*
     * You are an avid rock collector who lives in southern California. Some rare 
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
        if( row<0 || col >= grid[0].length){
            return 0;
        }
        if(row == 0 && col == grid[0].length-1){
            return grid[row][col];

        }

        int moveUp = optimalPath(grid, row-1, col);
        int moveleft =  optimalPath(grid, row, col+1);

        System.out.println(moveUp);
        return grid[row][col] + Math.max(moveleft, moveUp);
    }
    public static int optimalPath(int[][] grid){
        return optimalPath(grid, grid.length-1, 0);
    }

    /*
     * climbing stairs
     * You are climbing a staircase. It takes n steps to reach the top.

        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

        Example 1:

        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps
     */

    public static int climbing(int n, HashMap<Integer, Integer> mem){
        if(n==0|| n==1){
            return 1;
        }
        if(!mem.containsKey(n)){
            mem.put(n, climbing(n-1, mem) + climbing(n-2,mem));
        }
        return mem.get(n);
    }
    public static int climbingStairs(int n){
        HashMap<Integer, Integer> mem = new HashMap<>();
        return climbing(n , mem);
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
    public static String reverse(String s){
        int i = 0;
        int j = s.length()-1;
        char[] charArray = s.toCharArray();
        while(i<j){
            if(!Character.isAlphabetic(charArray[i])){
                i++;
            }else if(!Character.isAlphabetic(charArray[j])){
                j--;
            }else{
                if(Character.isUpperCase(charArray[i]) && Character.isLowerCase(charArray[j])){
                    char temp = charArray[i];
                    charArray[i] = Character.toUpperCase(charArray[j]);
                    charArray[j] = Character.toLowerCase(temp);
                }else if(Character.isUpperCase(charArray[j]) && Character.isLowerCase(charArray[i])){
                    char temp = charArray[i];
                    charArray[i] = Character.toLowerCase(charArray[j]);
                    charArray[j] = Character.toUpperCase(temp);
                }else{
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
                j--;
                i++;
            }
        }
        return new String(charArray);
    }
    public static String reverseString(String s){
        String[] splitString = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : splitString){
            sb.append(reverse(str)).append(" ");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0, 0, 5},
            {0, 1, 1, 1, 0},
            {2, 0, 0, 0, 0}
        };
        // System.out.println(reverseString("I am, Robot!").equals("I ma, Tobor!"));
        // System.out.println(optimalPath(grid));
        System.out.println(hermioneString("AABAAB"));
    }

}
