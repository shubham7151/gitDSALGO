import java.util.*;

public class Practice {

    Object obj = new Object();
    HashMap
    
    /*
     * Implement a method which performs basic string compression by counting sequences of repeating characters. 
     * Given "AABBBCCCD" it should return "A2B3C3D1"
     */

    public static String stringCompression(String s){
        if(s.length()==0){
            return "";
        }
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        sb.notify();
        for( int i = 1; i<s.length();i++){
            if(s.charAt(i) != s.charAt(i-1)){
                sb.append(s.charAt(i-1));
                sb.append(counter);
                counter = 1;
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
        Read this character in if it is either. This determines if the final result is negative or positive respectively. 
        Assume the result is positive if neither is present. Read in next the characters until the next non-digit character or the end of the input is reached. 
        The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 
        If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). 
        If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. 
        Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 
        Return the integer as the final result.
     */

     public static int myAtoi(String s){
        //ignore space
        // check sign
        // // read if digit
        // clamp in int range
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        int i = 0;
        boolean isPositive = true;
        if(s.charAt(i) == '-'){
            isPositive = false;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
        int res = 0;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(res > (Integer.MAX_VALUE - digit)/10){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            i++;
        }
        return res;
     }

    /*
     *     3 Hermione is preparing a cheat-sheet for her final exam in Potions class. 
            To create a potion, one must combine ingredients in a specific order, any of which may be repeated. 
            As an example, consider the following potion which uses 4 distinct ingredients 
            (A,B,C,D) in 11 steps: A, B, A, B, C, A, B, A, B, C, D.  
            Hermione realizes she can save tremendous space on her cheat-sheet by introducing a 
            special instruction, '*', which means "repeat from the beginning". 
            Using these optimizations, Hermione is able to encode the potion above using only 6 characters: A,B,*,C,*,D 
     */

    public static String magicPR(String s, int ind, StringBuilder encodedString){
        if( ind >= s.length()){
            return encodedString.toString();
        }
        if(ind != 0 && 2*ind <= s.length()){
            String comp = s.substring(0, ind);
            if(comp.equals(s.substring(ind,2*ind))){
                encodedString.append("*");
                String res1 = magicPR(s, 2*ind, new StringBuilder(encodedString));
                encodedString.setLength(encodedString.length()-1);
                encodedString.append(s.charAt(ind));
                String res2 = magicPR(s, ind+1, new StringBuilder(encodedString));
                return res1.length() < res2.length() ? res1 : res2;
            }
        }
        encodedString.append(s.charAt(ind));
        return magicPR(s, ind+1, new StringBuilder(encodedString));
    }
    public static int magicPortion(String s){
        String st = magicPR(s, 0, new StringBuilder());
        System.out.println(st);
        return st.length();
    }
    /*
     * Find the missing alphabets from a panagram
     */
    public static String missingAlphabet(String s){
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        String temp = "qwertyuiopasdfghjklzxcvbnm";
        for( Character st : temp.toCharArray()){
            hm.put(st, 0);
        }    
        for(Character st : s.toCharArray()){
            if(hm.containsKey(st)){
                hm.put(st, hm.get(st)+1);
            }
        }
        for(Map.Entry<Character, Integer> t : hm.entrySet()){
            if(t.getValue()==0){
                sb.append(t.getKey());
            }
        }
        return sb.toString();
    }

    /*
     * Given a list of student test scores, find the best average grade. Each student may have more than one test score in the list.
        Complete the bestAverageGrade function in the editor below. It has one parameter, scores, which is an array of student test scores. Each element in the array is a two-element array of the form [student name, test score] e.g. [ "Bobby", "87" ].
        Test scores may be positive or negative integers.


            If you end up with an average grade that is not an integer, you should use a floor function to return the largest integer less than or equal to the average. Return 0 for an empty input.


        Example:


        Input:
        [ 
            [ "Bobby", "87" ],
            [ "Charles", "100" ],
            [ "Eric", "64" ],
            [ "Charles", "22" ] 
        ].

        Expected output: 87
     */

    public static double bestAvg(String[][] s){
        // loop thriugh the arry and group marks of users using hashmap
        // sum the hashmap and find avg. save into arr
        // loop through the arr and find max;
        HashMap<String, List<Integer>> groupMap = new HashMap<>();
        for(int i = 0; i<s.length; i++){
            String name = s[i][0];
            int score = Integer.parseInt(s[i][1]);
            if(groupMap.containsKey(name)){
                groupMap.get(name).add(score);
            }else{
                List<Integer> t = new ArrayList<>();
                t.add(score);
                groupMap.put(name, t);
            }
        }
        double res = 0;
        // StringBuilder std = new StringBuilder();
        for(Map.Entry<String, List<Integer>> st : groupMap.entrySet()){
            double sum = 0;
            for( double t : st.getValue()){
                sum+=t;
            }
            double avg =  sum/st.getValue().size();
            res = Math.max(avg,res);
        } 
        return res;
    }

    /*
     * Find the second largest number in the array
     */

    public static int secondLargest(int[] nums){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for( int i : nums){
            if(i > largest){
                secondLargest = largest;
                largest = i ;
            }else if(i > secondLargest && i != largest){
                secondLargest = i;
            }
        }
        return secondLargest;
    }
    /*
     * Find the second smallest number in the array 
        e.g. [2,5,6,8] 
        O/P : 5
     */

     public static int secondSmallest(int[] nums){
        int small = Integer.MAX_VALUE;
        int secSmall = Integer.MAX_VALUE;

        for( int i : nums){
            if(i<small){
                secSmall = small;
                small = i;
            }else if(i < secSmall && i != small){
                secSmall = i;
            }
        }

        return secSmall;
    }

    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
    There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
    For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
    If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

     public static int lastAlive(int n , int k ){
        ArrayList<Integer> arr = new ArrayList<>();
        for( int i = 0; i<n;i++){
            arr.add(i+1);
        }
        int j = 0;
        while(arr.size()!=1){
            int removePerson = (j+k-1)% arr.size();
            arr.remove(removePerson);
            j = removePerson;
        }
        return arr.get(0);
     }

    /*
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
     * return the median of the two sorted arrays. 
     * The overall run time complexity should be O(log (m+n)).
     */

    public static double medianSortedArray(int[] nums1, int[] nums2){
        // new arr of size num1+num2
        // add elements from both in array
        // if even its mid-1 + mid /2 
        // else mid/2
        int[] arr = new int[nums1.length+nums2.length];

        int i = 0; //num1
        int j = 0; //num2
        int k = 0; //arr
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
                k++;
            }else if(nums1[i] > nums2[j]){
                arr[k] = nums2[j];
                j++;
                k++; 
            }
        }

         // add left element
        while( i < nums1.length){
            arr[k] = nums1[i];
            k++;
            i++;
        }
        while(j < nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        double mid = 0; 
        if(arr.length % 2 ==1){
            mid = arr[arr.length/2];
        }else{
            mid =  ( arr[arr.length/2] + arr[arr.length/2-1] ) / 2.0;
        }
        return mid;
    }

    public static int medianSortedArrayBetterComplexicity(int[] nums1, int[] nums2){
        // [_,_,_,_,_] && [_,_,_]
        // select smaller arr
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2){
            return medianSortedArrayBetterComplexicity(nums2,nums1);
        }
        // 
        int i = 0; // left of smaller arr
        int j = n1; // right for smaller arr
        while(i<=j){
            int midSmall = (i+j)/2;
            int midLarge = (n1+n2)/2 - midSmall;

            int lsmall = midSmall > 0 ? nums1[midSmall-1] : Integer.MIN_VALUE;
            int rsmall = midSmall < n1 ? nums1[midSmall] : Integer.MAX_VALUE;
            int llarge = midLarge > 0 ? nums2[midLarge-1] : Integer.MIN_VALUE;
            int rlarge = midLarge < n2 ? nums2[midLarge] : Integer.MAX_VALUE;

            if(lsmall <= rlarge && rsmall <= llarge){
                if((n1+n2)%2 == 1){
                    return Math.max(lsmall, llarge);
                }else{
                    return (int)(Math.max(lsmall, llarge) + Math.min(rsmall, rlarge))/2;
                }
            }else if(lsmall > rlarge){
                j = midSmall-1;
            }else{
                i = midSmall+1;
            }
            
        }
        return 0;
    }
    /*
     * Find the mostly used IP Address (Apache Log Pattern) from String[] - 
     * Completed within 18 mins and covered all the test cases and added all the edged cases as well.
     * String[] s = {"10.0.0.1 - log entry 1 11", "10.0.0.1 - log entry 2 213", "10.0.0.2 - log entry 1 11", "10.0.0.2 - log entry 2 213", "10.0.0.2 - log entry 133132"};
     */

    public static String mostFrequentIP(String[] s){
        // use hashmap to store ip and its count
        HashMap<String, Integer> hm = new HashMap<>();
        for( String t : s){
            String[] temp = t.split("-");
            String localIP = temp[0].trim();
            if(hm.containsKey(localIP)){
                hm.put(localIP , hm.get(localIP)+1);
            }else{
                hm.put(localIP, 1);
            }
        }
        // find maxIp
        int max = 0;
        String ip = null;
        for(Map.Entry<String, Integer> temp : hm.entrySet()){
            if(temp.getValue() > max){
                max = temp.getValue();
                ip = temp.getKey();
            }
        }
        return ip;
    }

    /*
     * /* Problem Name is &&& Train Map &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Consider adding some additional tests in doTestsPass().
 * 3) Implement def shortestPath(self, fromStationName, toStationName)
 * method to find shortest path between 2 stations
 * 4) If time permits, some possible follow-ups.
 */

/*
      Visual representation of the Train map used
 
       King's Cross St Pancras --- Angel ---- Old Street
       |                   \                            |
       |                    \                            |
       |                     \                            |
       Russell Square         Farringdon --- Barbican --- Moorgate
       |                                                  /
       |                                                 /
       |                                                /
       Holborn --- Chancery Lane --- St Paul's --- Bank
     */

     private static class Station {
        private String name;
        private List<Station> neighbours;
    
        public Station(String name) {
          this.name = name;
          this.neighbours = new ArrayList<>(3);
        }
    
        String getName() {
          return name;
        }
    
        void addNeighbour(Station v) {
          this.neighbours.add(v);
        }
    
        List<Station> getNeighbours() {
          return this.neighbours;
        }
    
        @Override
        public boolean equals(Object obj) {
          return obj instanceof Station && this.name.equals(((Station) obj).getName());
        }
    
        @Override
        public int hashCode() {
          return Objects.hash(this.name);
        }
      }
    
      /**
       * class TrainMap
       * <p>
       * Respresents whole rail network - consists of number of the Station objects.
       * Stations in the map are bi-directionally connected. Distance between any 2 stations
       * is of same constant distance unit. This implies that shortest distance between any
       * 2 stations depends only on number of stations in between
       */
      private static class TrainMap {
    
        private HashMap<String, Station> stations;
    
        public TrainMap() {
          this.stations = new HashMap<>();
        }
    
        public TrainMap addStation(String name) {
          Station s = new Station(name);
          this.stations.putIfAbsent(name, s);
          return this;
        }
    
        public Station getStation(String name) {
          return this.stations.get(name);
        }
    
        public TrainMap connectStations(Station fromStation, Station toStation) {
          if (fromStation == null) {
            throw new IllegalArgumentException("From station is null");
          }
          if (toStation == null) {
            throw new IllegalArgumentException("From station is null");
          }
          fromStation.addNeighbour(toStation);
          toStation.addNeighbour(fromStation);
          return this;
        }
    
        public List<Station> shortestPath(String from, String to) {
        /*
         * TODO Implement
         */
          
         // hashmap contain key as station and their parent
         // q to implement BFS
         // add start to q, and map with null as parent
         // loop through till q is not empty // check if station is in hashmap if so ignore else add it to q and in shamap
         // loop from end and insert into ourput array 
            Queue<Station> q = new LinkedList<>();
            HashMap<Station, Station> parentStation = new HashMap<>();
            Station start = getStation(from);
            Station end = getStation(to);
            q.add(start);
            parentStation.put(start,null);

            while(!q.isEmpty()){
                Station curr = q.poll();
                if(curr.getName().equals(to)){
                    break;
                }
                for(Station xyz : curr.getNeighbours()){
                    if(!parentStation.containsKey(xyz)){ // only once
                    q.add(xyz);
                    parentStation.put(xyz, curr);
                    }
                }
            }

            List<Station> output = new ArrayList<>();
            while(end!=null){
                output.add(end);
                end = parentStation.get(end);
            }
            Collections.reverse(output);
            return output;
          
        }
    
        public static String convertPathToStringRepresentation(List<Station> path) {
          if (path.isEmpty()) {
            return "";
          }
          return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
        }
      }
    
    
      public static boolean doTestsPass() {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        TrainMap trainMap = new TrainMap();
    
        trainMap.addStation("King's Cross St Pancras").addStation("Angel").addStation("Old Street").addStation("Moorgate")
            .addStation("Farringdon").addStation("Barbican").addStation("Russel Square").addStation("Holborn")
            .addStation("Chancery Lane").addStation("St Paul's").addStation("Bank");
    
        trainMap.connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Angel"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Farringdon"))
            .connectStations(trainMap.getStation("King's Cross St Pancras"), trainMap.getStation("Russel Square"))
            .connectStations(trainMap.getStation("Russel Square"), trainMap.getStation("Holborn"))
            .connectStations(trainMap.getStation("Holborn"), trainMap.getStation("Chancery Lane"))
            .connectStations(trainMap.getStation("Chancery Lane"), trainMap.getStation("St Paul's"))
            .connectStations(trainMap.getStation("St Paul's"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Angel"), trainMap.getStation("Old Street"))
            .connectStations(trainMap.getStation("Old Street"), trainMap.getStation("Moorgate"))
            .connectStations(trainMap.getStation("Moorgate"), trainMap.getStation("Bank"))
            .connectStations(trainMap.getStation("Farringdon"), trainMap.getStation("Barbican"))
            .connectStations(trainMap.getStation("Barbican"), trainMap.getStation("Moorgate"));
    
        String solution = "King's Cross St Pancras->Russel Square->Holborn->Chancery Lane->St Paul's";
    
        return solution.equals(TrainMap.convertPathToStringRepresentation(trainMap.shortestPath("King's Cross St Pancras", "St Paul's")));
      }


    /*
    * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. Find a cycle and return its length. No cycle is found -> -1. 
        lengthOfCycle([1, 0], 0); // 2 
        lengthOfCycle([1, 2, 0], 0); // 3 
        lengthOfCycle([1, 2, 3, 1], 0); // 3 
   */

    public static int cycleArray(int[] nums, int startIndex){
        // hashmap wot confirm cycle // step to count steps 
        int steps = 0;
        int curr = startIndex;
        HashMap<Integer, Integer> hm = new HashMap<>();
        while( curr >=0 && curr < nums.length){
            if(hm.containsKey(curr)){
                return steps - hm.get(curr);
            }
            hm.put(curr, steps);
            steps++;
            curr = nums[curr];
        }

        return -1;
    }

    /*
     * Given a string str and an integer L. The task is to print all the unique substring of length L from string str.  
    Examples: Input: str = “abca”, L=3 
    Output: “abc”, “bca” Input: str = “aaaa”, L=3 
    Output: “aaa” 
    Example case : aab, length=2; result is aa, ab 
     */

    public static List<String> uniqueString(String s, int L){
        int l = 0;
        int r = L;
        List<String> outpur = new ArrayList<>();
        while( r<=s.length()){
            String t = s.substring(l, r);
            if(!outpur.contains(t)){
                outpur.add(t);
            }
            l++;
            r++;
        }
        System.out.println(outpur);
        return outpur;
    }

    /*
     * Implement a function which calculates whether a number is a power of 10. 
        Boolean is PowerOfTen (int number)
     */

    public static boolean powerOfTen(int n){
        if(n<=0) return false;
        while(n>1){
            if(n%10 != 0) return false;
            n = n/10;
        }
        return true;
    }

    /*
     * 
     * Implement a function which returns a string representation of the decimal expansion of a fraction. This function should handle repeating parts by enclosing them in brackets as follows 
        1/2 -> "0.5" 
        1/3 -> "0.(3)" 
        22/7 -> "3.(142857)" 
        String fraction Expansion(long numerator, long denominator) 
     */

    public static String decimalExp(int num , int den){
        // cehck sign
        // remove intege
        // add decimal
        // long division
        boolean ispos = true;
        if((num< 0 && den > 0) || (num > 0 &&  den<0)){
            ispos = false;
        }
        num = Math.abs(num);
        den = Math.abs(den);
        StringBuilder sb = new StringBuilder();
        sb.append(num/den);
        int rem = num%den;

        if(rem==0){
            return sb.toString();
        }
        sb.append(".");
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(rem!=0){
            if(hm.containsKey(rem)){
                sb.insert(hm.get(rem), "(");
                sb.append(")");
                break;
            }
            hm.put(rem, sb.length());
            rem = rem*10;
            sb.append(rem/den);
            rem = rem %10;
        }

        return sb.toString();
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

     public static String rev(String s){
        StringBuilder sb = new StringBuilder();
        String[] st = s.split(" ");
        for(String t : st){
            sb.append(reverSeString(t)).append(" ");
        }
        return sb.toString();
     }
    
    public static String reverSeString(String s ){
        
        char[] st = s.toCharArray();

        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(!Character.isAlphabetic(st[i])){
                i++;
            }else if(!Character.isAlphabetic(st[j])){
                j--;
            }else{
                if(Character.isUpperCase(st[i])){
                    char temp = st[i];
                    st[i] = Character.toUpperCase(st[j]);
                    st[j] = Character.toLowerCase(temp);
                }else if(Character.isUpperCase(st[j])){
                    char temp = st[i];
                    st[i] = Character.toLowerCase(st[j]);
                    st[j] = Character.toUpperCase(temp);
                }else{
                    char temp = st[i];
                    st[i] = st[j];
                    st[j] = temp;
                }
                
                i++;
                j--;
            }
            
        }

        return new String(st).trim();
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
        HashMap<Character, Integer> hs = new HashMap<>();
        for(Character s : input.toCharArray()){
            if(hs.containsKey(s)){
                hs.put(s, hs.get(s)+1);
            }else{
                hs.put(s, 1);
            }
        }

        for(Character s : input.toCharArray()){
            if(hs.get(s)==1){
                return s;
            }
        }
        return '0';
    }

    /*
     *     24 Return the highest substring length and index value. 
            1.1 EX: AAABBBBBBBBCCVV
            1.2 Output: B 8
     */
    public static void highestSubString(String s){
        int i = 0; 
        int j = 1;
        int start = 0;
        int end = 0;
        char c = '\0';
        int len = 0;
        int max = 0;
        while(j < s.length()){
            if(s.charAt(i)!=s.charAt(j)){
                len = j-i;
                if( len > max){
                    max = len;
                    start = i;
                    end = j;
                    c = s.charAt(i);
                }
                i = j;
            }
            j++;
        }
        len = j-i;
        if( len > max){
            max = len;
            start = i;
            end = j;
            c = s.charAt(i);
        }

        System.out.println(c +"="+ max +"=" +start + "=" + end );
    }

    /*
     * rotate left 1 times
     */
    public static int[] rotateLeft(int[] nums){
        int temp = nums[0];
        for( int i = 0; i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = temp;
        return nums;
    }
    /*
     * rotate left k times
     */
    
    public static int[] rotateLeft(int[] nums, int k){
        for( int i = 0; i<k%nums.length;i++){
            rotateLeft(nums);
        }
        return nums;
    }
    /*
     * rotate right 1 times
     */
    public static int[] rotateRight(int[] nums){
        int temp = nums[nums.length-1];
        for( int i = nums.length-1; i>0;i--){
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
        return nums;
    } 
    /*
     * rotate right k times
     */
    public static int[] rotateRight(int[] nums, int k){
        for( int i = 0; i<k%nums.length;i++){
            rotateRight(nums);
        }
        return nums;
    }
    /*
     * rotate using reverse
     * left
     */
    public static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
    }
    public static int[] rotateLeftReverse(int[] nums, int k){
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        return nums;
    }
    public static int[] rotateRightReverse(int[] nums, int k){
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        return nums;
    }

    /*
     * Balanced bracket
     */
    /*
     * ({})
     */
    
    public static boolean validParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt('i') == ']')){
                    char ch = stack.pop();
                    if ((s.charAt(i) == ')' && ch != '(') || 
                        (s.charAt(i) == ']' && ch != '[') ||
                        (s.charAt(i) == '}' && ch != '{')){
                            return false;
                        }
                }else return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }
    /*
     * Minimum Remove to Make Valid Parentheses
     */

    
    public static void main(String[] args) {
        for( int i : rotateRight(new int[] {1,2,3,4,5},3)){
            System.out.println(i);
        }
        System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOO");
        for( int i : rotateRightReverse(new int[] {1,2,3,4,5},3)){
            System.out.println(i);
        }
    }
    
}
