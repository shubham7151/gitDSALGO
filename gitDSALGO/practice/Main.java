import java.util.*;
import gitDSALGO.linkedList.SinglyLinkedList.*;;
public class Main {
    /* box pattern */ 
    /*
    for (int i =0;i<5;i++){
        for (int j = 0 ; j<5;j++){
            System.out.print("*");
        }
        System.out.println();
    }
     * 
     */

    /* right triangle */
    /*
     * for(int i=0; i<5 ;i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
     */

    /* Number right Triangle
     * for(int i=0; i<5 ;i++){
            for(int j = 0; j <= i; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
     */
    /*
     * for(int i=0; i<5 ;i++){
            for(int j = 0; j <= i; j++){
                System.out.print(i+1);
            }
            System.out.println();
        }
     */


    /* reverse right triangle */
    /*
     *  for(int i = 0; i<5; i++){
            for (int j = 5 ; j > i ; j-- ){
                System.out.print("*");
            }
            System.out.println();
        }
     */

    /* reverse triangle Number */
    /*
     * for(int i = 5; i>0; i--){
            for (int j = 0 ; j < i ; j++ ){
                System.out.print(j+1);
            }
            System.out.println();
        }
     */

    /* Given an integer N, write a program to count the number of digits in N */
    /*
    Brute Force
     * int n = 3663132;
        int count = 0;
        while(n!=0){
            n = n/10;
            count++;
        }
        System.out.println(count);
     */
    /* Log Base
     * intuation : the number of digit is upper bound of log10(n)
     * 
     * int n = 3663132;
     * System.out.println((int) Math.log10(n) + 1);
     */

    /* Reverse a Number */
    /*
     * int n = 1234;
        int newNumber = 0;
        int i = 0;
        while (n!=0){
            int r = n % 10;
            n = n / 10;
            newNumber = (newNumber * 10) + r;
            i++;
        }
        System.out.println(newNumber);
     */

    /* Pallindrome */
    /*
     * int m = 1211;
        int n = m;
        int reverseNumber = 0;
        while(n!=0){
            int r = n%10;
            n = n/10;
            reverseNumber = reverseNumber * 10 + r;
        }
        System.out.println(reverseNumber);
        System.out.println(n);
        if (reverseNumber == m){
            System.out.println("The string is pallindrome");
        } else {
            System.out.println("The string is not pallindrome");
        }
     */

    /* GCD */
    /* BruteForce
     * int num1 = 4;
        int num2 = 8;
        int smaller = 0;
        int gdf = 0;
        if (num1 < num2) smaller = num1;
        else smaller = num2;

        for(int i = 1; i <= smaller;i++){
            if ((num1 % i == 0) && (num2 % i == 0)){
                if(i > gdf) gdf = i;
            }
        }
        System.out.println(gdf);
     */

    /* ARMSTRING Number */
    /*int n = 15;
        int m = n;
        int count = 0;
        int newSum = 0;
        while(m!=0){
            m = m /10;
            count++;
        }
        m = n;
        while(m!=0){
            int r = m % 10;
            newSum = newSum + (int) Math.pow(r,count);
            m = m/10;
        }

        if (newSum != n){
            System.out.println("Not ArmString number");
        } else {
            System.out.println(" ArmString number");
        }
     * 
     */

     /* =============================================================================== */
    /* Recurrisive  */
    /* print number from 0 to 3 */
    /*
     *   static int x = 0;
    static void print(){
        if (x == 3){
           return;
        }
        System.out.println(x);
        x++;
        print();
    }
     */

     /* print name n times */
     /*static void fnPrintName(int i , int n){
        if (i == n){
            return;
        }
        System.out.println("Shubham");
        fnPrintName(i+1, n);
     }
      * 
      */
    
    /* print number 1 to n */
    /*static void printNumber(int i, int n){
        if (i>=n){
            return; 
        }
        System.out.println(i);
        printNumber(i+1, n);
    }
     * 
     */
    /* print number n to 1 */
    /*
     * static void printNumber(int i, int n){
        if (i<n){
            return; 
        }
        System.out.println(i);
        printNumber(i-1, n);
    }
     */
    
     /* sum of first n natural number  */
    /* By recursion */
    /*
     * static int sumNum(int i){
        if (i==0){
            return 0;
        }
        return i + sumNum(i-1);
    }
     */
    
     /* Factorial of n natural number */
    /*
     * static int factNum(int i){
        if (i == 1){
            return 1;
        }
        return i * factNum(i-1);
    }
     */

     /* reverse an array */
    /*  similar two pointer approach
     * static void reverseArray(int[] arr, int start, int end){
        if(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }
    */
    /* Fibbonacchi Number */
    // static int fib(int n){
    //     if (n <= 1){
    //         return n;
    //     }
    //     return fib(n-1)+fib(n-2);
    // }

    /* Selection Sort */ /* o(N^2) */

    // static int[] selectionSort(int arr[]){
    //     for (int i = 0; i <= arr.length - 1 ; i++){
    //         int minValue = i;
    //         for(int j = i+1 ; j <= arr.length - 1;  j++){
    //             if (arr[j] < arr[minValue]){
    //                 minValue = j;
    //             }
    //         }
    //         int temp = arr[minValue];
    //         arr[minValue] = arr[i];
    //         arr[i] = temp; 
    //     }
    //     return arr;
    // }

    /* Bubble Sort */ /* O(N^2) */
    /*
     * static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length - 1 ; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
        return arr;
    }
     */

    
    /* Insertion sort */
    /*
    static int[] insertionSort(int[] arr){
        for (int i = 1; i<arr.length;i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
        return arr;
    }
     * 
     */

    /* merge sort 
        Divide and copnquer 
        time complexicity O(nlogn)
    */ 

    // static void merge(int[] left, int[] right, int[] arr){
    //     int leftSize = arr.length/2;
    //     int rightSize = arr.length - leftSize;

    //     int i = 0, l =0 , r = 0; // indices

    //     // conditionf ormerging
    //     while(l<leftSize && r < rightSize){
    //         if(left[l] < right[r]){
    //             arr[i]= left[l];
    //             i++;
    //             l++;
    //         } else {
    //             arr[i] = right[r];
    //             i++;
    //             r++;
    //         }
    //     }

    //     while(l<leftSize){
    //         arr[i]= left[l];
    //         i++;
    //         l++;
    //     }
    //     while(r<rightSize){
    //         arr[i]= right[r];
    //         i++;
    //         r++;
    //     }
    // }

    // static void mergeSort(int[] arr){
    //     int length = arr.length;
    //     if (length<=1) return; 
    //     int middle = length / 2;
    //     int[] left = new int[middle];
    //     int[] right = new int[length-middle];

    //     int i = 0;
    //     int j = 0;
    //     for(;i<length;i++){
    //         if(i<middle){
    //             left[i] = arr[i];
    //         }else {
    //             right[j] = arr[i];
    //             j++;
    //         }
    //     }
    //     mergeSort(left);
    //     mergeSort(right);
    //     merge(left, right, arr);
    // }
    
    /* convert this to use array list collection instead of array */

    /* =================================== */
    /* quick sort */

    /* =================================== */


    /* Find the largest element  in an array 
     * 
     * complexcity O(N)
    */
    // static int largest(int[] arr){
    //     int largest = arr[1];
    //     for(int i =1; i<arr.length;i++){
    //         if (arr[i]>largest){
    //             largest = arr[i];
    //         }
    //     } 
    //     return largest;
    // }
    // static int secondLargest(int[] arr){
    //     int largest = Integer.MIN_VALUE;
    //     int second_largest = Integer.MIN_VALUE;

    //     for(int i : arr){
    //         largest = Integer.max(largest,i);
    //     }

    //     for (int i : arr){
    //         if( i > second_largest && i != largest){
    //             second_largest = i;
    //         }
    //     }

    //     return second_largest;
    // }

    /* check if an array is sorted */

    // static boolean sortedArray(int[] arr){
    //     for (int i = 0; i < arr.length - 1 ; i++){
    //         if (arr[i] > arr[i+1]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    /* Remove duplicate in-place from sorted array */
    /* Problem Statement: Given an integer array sorted in non-decreasing order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
    If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements. */

    // static int removeDuplicateInPlace (int[] nums){
    //     int i = 0;
    //     for (int j = 1; j < nums.length; j++){
    //         if(nums[i] != nums[j]){
    //             i++;
    //             nums[i] = nums[j];
    //         }
    //     }
    //     return i+1; 
    // }

    /* Move all Zeros to the end of the array */
    /* Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order. */

    // static int[] moveZeroToEnd(int[] arr){
    //     int j =-1;
    //     for(int i = 0; i<arr.length;i++){
    //         if(arr[i]==0){
    //             j = i;
    //             break;
    //         }
    //     }

    //     if(j == -1) return arr;

    //     for(int i = j+1; i<arr.length; i++){
    //         if(arr[i]!=0){
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //             j++;
    //         }
    //     }

    //     return arr;
    // }

   /* Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array. */
//     static int missingElement(int[] arr){
//     int numberOfarr = arr.length+1;
//     int sumOfNelement = (numberOfarr*(numberOfarr+1))/2;
//     int sumOfElementInArr = 0;

//     for (int i : arr) {
//         sumOfElementInArr += i;
//     }
//     return  sumOfNelement - sumOfElementInArr ;
//    }

    /* Given a binary array nums, return the maximum number of consecutive 1's in the array. */
    // static int consecutiveOnes(int[] arr){
    //     int count =0; int maxCount = 0;

    //     for(int i : arr){
    //         if(i == 1){
    //             count++;
    //             if(count > maxCount){
    //                 maxCount = count;
    //             }
    //         } if(i ==0){
    //             count = 0;
    //         }
    //     }

    //     return maxCount;
    // }

    /* Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one. */

    // static int singleNumber(int[] arr){
    //     HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    //     for(int i =0;i<arr.length;i++){
    //         if(hm.containsKey(arr[i])){
    //             hm.put(arr[i], hm.get(arr[i])+1); 
    //         } else{
    //             hm.put(arr[i], 1);
    //         }
    //     }
    //     for(int i : hm.keySet()){
    //         if (hm.get(i) == 1){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    /* Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k. */
    // static int longestSubArrayWithSum(ArrayList<Integer> arr, int sum){
    //     int i =0; int j = 0; int ll = 0; int ml =0; int preSum = 0;
    //     while(j < arr.size()){
    //         preSum += arr.get(j);
    //         ll++;
           
    //         if(preSum == sum){
                
    //             ml = Math.max(ml, ll);
    //             ll = 1;
    //         }
    //         if(preSum > sum ){
    //             preSum -= arr.get(i);
    //             i++; 
    //         }
    //         j++;
    //     }
    //     return ml;
    // }
    

    /* Longest Harmonious Subsequence */
    /* We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1. */
    
    // static int lhs(int[] arr){
    //     int j = 0;
    //     int counter = 0;
    //     for(int i = 0; i< arr.length;i++){
    //         int tempMax = Math.max(arr[i], arr[j]);
    //         int tempMin = Math.min(arr[i], arr[j]);
    //         if(tempMax-tempMin == 1){
    //             counter++;
    //             j++;
    //         }
    //     }  
    //     return counter;
    // }

    /* Two Sum */
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    // You may assume that each input would have exactly one solution, and you may not use the same element twice.

    // You can return the answer in any order.

    /* the complexcity O(n2) */
    // static int[] sum2(int[] arr, int target){
    //     int[] returnArr = new int[2];
    //     for(int i = 0;i<arr.length;i++){
    //         int findNumber = target - arr[i];
    //         returnArr[0] = i;
    //         for(int j = i+1;j<arr.length;j++){
    //             if(arr[i]!= arr[j] && arr[j]==findNumber){
    //                 returnArr[1] = j;
    //                 return returnArr;
    //             }
    //         }
    //     }
    //     return returnArr;
    // }

    // static int[] sum2(int[] nums, int target){
    //     int[] returnArr = {-1,-1};
    //     Map<Integer, Integer> hp = new HashMap<>();
    //     for(int i = 0;i<nums.length;i++){
    //         int findNumber = target - nums[i];
    //         if(hp.containsKey(findNumber)){
    //             returnArr[0] = i;
    //             returnArr[1] = hp.get(findNumber);
    //         }else {
    //             hp.put(nums[i], i);
    //         }
    //     }

    //     return returnArr;
    // }

    /* Sort Colors {Dutch National flag algorithm.}*/
    // Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    // You must solve this problem without using the library's sort function.

    // static void sortColor(int[] nums){
    //     int low = 0;int mid = 0; int high = nums.length-1;

    //     while(mid < high){
    //         if(nums[mid]==0){
    //             int temp = nums[low];
    //             nums[low] = nums[mid];
    //             nums[mid] = temp;
    //             mid++;low++;
    //         }
    //         if(nums[mid]==1){
    //             mid++;
    //         }
    //         if(nums[mid]==2){
    //             int temp = nums[high];
    //             nums[high] = nums[mid];
    //             nums[mid] = temp;
    //             high--;
    //         }
    //     }
    // }

        // public static int majorityElement(int[] nums) {
        //     HashMap<Integer,Integer> hp = new HashMap<>();
    
        //     for(int i =0;i<nums.length;i++){
        //         if(hp.containsKey(nums[i])){
        //             hp.put(nums[i], hp.get(nums[i])+1);
        //         }else{
        //             hp.put(nums[i],1);
        //         }
    
        //         if(hp.get(nums[i]) > nums.length/2){
        //             return nums[i];
        //         }
        //     }
        //     return 0;
        // }

        // public static int majorityElement(int[] nums) {
        //     int element = nums[0];
        //     int count=1;
        //     for(int i = 1;i<nums.length;i++){
        //         if(nums[i] == element){
        //             count++;
        //         }else if(nums[i] != element){
        //             count--;
        //             element = nums[i];
        //         }
        //     }
        //     System.out.println(element);
        //     int cnt = 0;
        //     for(int i : nums){
        //         if(i == element) cnt++;
        //     }
        //     if(cnt > nums.length/2){
        //         return element;
        //     }
        //     return -1;
        // }

        /* Maximum Subarray */

        // Given an integer array nums, find the subarray with the largest sum, and return its sum.

        // public static int maxSubArray(int[] nums){
        //     int maxSum = Integer.MIN_VALUE;
        //     int sum = 0;
        //     for(int i = 0; i<nums.length;i++){
        //         sum += nums[i];
        //         if(sum > maxSum){
        //             maxSum = sum;
        //         }
        //         if(sum < 0){
        //             sum = 0;
        //         }
        //     }

        //     return maxSum;
        // }

        /* Best Time to Buy and Sell Stock */
        // You are given an array prices where prices[i] is the price of a given stock on the ith day.

        // You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

        // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

        // public static int maxProfit(int[] prices) {
        //     int buy =0; int sell = 1; int profit = 0;
        //     int localsum = 0;

        //     while(sell < prices.length){
        //         localsum = prices[sell] - prices[buy];
        //         if(localsum == 0){
        //             buy=sell;
        //         }
        //         if(localsum < 0){
        //             localsum = 0;
        //             buy = sell;
        //         }if(localsum > 0){
        //             profit = Math.max(localsum, profit);
        //         }
        //         sell++;
        //     }

        //     return profit;
        // }

    /* Binary Search */
    // public static int bSearch(int[] nums, int target){
    //     int low = 0; int high = nums.length; 
       
    //     while(low<high){
    //         int mid = (high+low)/2;
    //         if(target < nums[mid]){
    //             high = mid;
    //         }else if(target > nums[mid]){
    //             low = mid;
    //         }else {
    //             return mid;
    //         }
            
    //     }
    //     return -1;
    // }
    // public static String reverseOfString(String s){
    //     String returnS = "";
    //     for(int i = s.length()-1; i>=0;i--){
    //       returnS+=s.charAt(i);
    //     }
    //     return returnS;
    //   }

    // public static String reverseOfString(String s){
    //     String returnS = "";
    //     for(int i = s.length()-1; i>=0;i--){
    //       returnS+=s.charAt(i);
    //     }
    //     return returnS;
    //   }
      
    //   public static String vertMirror (String strng) {
    //       // your code
    //     String returnString = "";
    //     String[] arr = strng.split("\n");
    //     for (int i=0; i<arr.length;i++){
    //       arr[i] = reverseOfString(arr[i]);
    //     }
    //     for(int i =0;i<arr.length;i++){
    //         // System.out.println(arr[i]);
    //       returnString += arr[i]+"\\n";
    //     }
    //     return returnString;
    //   }
    //   public static String horMirror (String strng) {
    //       // your code
    //     String returnString = "";
    //     String[] arr = strng.split("\n");
    //     for(int i = 0;i<=arr.length;i++){
    //       String temp = arr[i];
    //       arr[i] = arr[arr.length-i-1];
    //       arr[arr.length-i-1] = temp;
    //     }
    //     for(int i =0;i<arr.length;i++){
    //       returnString += arr[i]+"\\n";
    //     }
    //     return returnString;
    //   }

    // public static int solve(final List<List<Integer>> data) {
    //     int poss = 1;
    //       for(int i = 0; i< data.size();i++){
    //         Set<Integer> s = new HashSet<>();
    //         for(int j = 0; j < data.get(i).size();j++){
    //           s.add((data.get(i)).get(j));
    //         }
    //         poss *= s.size();
    //         System.out.println(s);
    //       }
    //      return poss;
    //   }

    // public static void c(int[] arr, int i){
        
    //     if(arr.length-i-1 >= 3){
            
    //         for(int j= i ;j<i+3;j++){
    //             arr[j] -= 1;
                
    //             if(arr[j]<0){
    //                 arr[j] = 0;
    //             }
    //         }
    //     }else {
            
    //         for(int j = i;j<arr.length;j++){
    //             arr[j] -= 1;
                
    //             if(arr[j]<0){
    //                 arr[j] = 0;
    //             }
    //         }
    //     }
        
    // }

//     public static int blowCandles(String str){
//     // Let's see how we gonna blow these candles...
    
//     int i = 0; int k =0;
    
//     String[] s = str.split("");
    
    
//     int[] arr = new int[s.length];
    
//     for(int j = 0;j<s.length;j++){
//         arr[j] = Integer.parseInt(s[j]);
//     }
    
//     while( i < arr.length){
    
//       // I should always point to leading non zero array
//         if(arr[i]==0){
//             i++;
//             continue;
//         }else{
//             c(arr,i);
//             k++;
//         }        
//     }
   
//     // k += arr[arr.length-1];
//     return k;
// }

// static String[] findWord(String x, String[] y){
//     String indexString = "";
//     for(int  i = 0; i<y.length;i++){
//       if(y[i].toLowerCase().contains(x.toLowerCase())){
//         indexString+=i+",";
//       }
//     }
//     // System.out.println(indexString);
//     if(indexString.length() == 0){
//       return new String[]{"Empty"};
//     }
//     String[] ss = indexString.split(",");
//     String[] returnArr = new String[ss.length];
//     for(int i =0;i<returnArr.length;i++){
//       returnArr[i] = y[Integer.parseInt(ss[i])];
//     }
//   return returnArr;
//   }

// public static String palindromization(String elements, int n) {
//     if(n == 0 || elements.length()==0){
//       return "Error!";
//     }
    
//     int j = 0;
    
//     String[] arr = new String[n];
//     if(n%2==0){
//         for(int i =0; i<n/2;i++){
//             arr[i]=String.valueOf(elements.charAt(j));
//             arr[n-i-1]=String.valueOf(elements.charAt(j));
//             j++;
//             if(j==elements.length()){
//               j=0;
//             }
//           }
//     }else{
//         for(int i =0; i<=n/2;i++){
//             arr[i]=String.valueOf(elements.charAt(j));
//             arr[n-i-1]=String.valueOf(elements.charAt(j));
//             j++;
//             if(j==elements.length()){
//               j=0;
//             }
//           }
//     }
    
//     String s = "";
//     for(int i = 0; i<arr.length;i++){
//       s+=arr[i];
//     }
//     return s;
//   }

//   public static String longestCommonPrefix(String[] strs) {
//     //loop through first element
//     //loop thhrough array and see if element in first = elemenet in ith e
//     String rs = "";
//     for(int i =0;i<strs[0].length() && i< strs.length;i++){
//         for(int j = 1; j<strs.length;j++){
//             if(strs[0].charAt(i) == strs[j].charAt(i) && j == strs.length){
//                 rs+=strs[0].charAt(i);
//             }else {
//     return rs;
//             }
//         }
//     }

//     return rs;
// }

// public static boolean isIsomorphic(String s, String t) {
//     if(s.length()!= t.length()) return false;
//     String visited = "";
//     for(int i = 0;i<s.length();i++){
//         if(!visited.contains(String.valueOf(s.charAt(i)))){
//             visited+=String.valueOf(s.charAt(i));
//             t = t.replace(String.valueOf(t.charAt(i)),String.valueOf(s.charAt(i)));
//         }
//         System.out.println(t);
//     }
//     // System.out.println(st);
//     if(t.equals(s)){
//         return true;
//     }
//     return false;
// }

// public static void setZeroes(int[][] matrix) {
//     Queue<int[]> q = new LinkedList<>();
//     for(int i = 0;i<matrix.length;i++){
//         for(int j = 0; j<matrix[0].length;j++){
//             if(matrix[i][j] == 0){
//                 q.add(new int[]{i,j});
//             }
//         }
//     }

//     while(!q.isEmpty()){
//         int[] zeroInd = q.poll();
//         System.out.println(zeroInd[0]+"z0");
//         System.out.println(zeroInd[1]+"z1");
//         //row
//         for(int i = 0; i<matrix[0].length;i++){
//             matrix[zeroInd[0]][i]=0;
//         }
        
//         //column
//         for(int i = 0; i<matrix.length;i++){
//             System.out.println(zeroInd[1]+"-" +i);
//             matrix[i][zeroInd[1]]=0;
//         }
//     }
// }

/* Implementation of LRU Cache */
//    class LRUCache{
//        class Node{
//
//            int key;
//            int value;
//            Node left;
//            Node right;
//
//            Node(int key, int value){
//                this.key = key;
//                this.value = value;
//                this.left = null;
//                this.right = null;
//            }
//        }
//
//        int capacity;
//        HashMap<Integer, Node> hp = new HashMap<>();
//        Node head = new Node(-1, -1);
//        Node tail = new Node(-1, -1);
//        LRUCache(int capacity){
//            this.capacity = capacity;
//        }
//
//        public  void put(int key, int value){
//            if(!hp.containsKey(key) && hp.size() == 0){
//                Node nn = new Node(key,value);
//                nn.right = tail;
//                tail.left = nn;
//                nn.left = head;
//                head.right = nn;
//                hp.put(key, nn);
//            }else if(!hp.containsKey(key) && hp.size() != this.capacity){
//                Node nn = new Node(key, value);
//                nn.right = head.right;
//                nn.left = head;
//                head.right.left = nn;
//                head.right = nn;
//                hp.put(key,nn);
//            }else {
//                hp.put(key, new Node(key, value));
//            }
//        }
//
//        public int get(int key){
//            if(hp.containsKey(key)){
//
//
//
//                return hp.get(key).value;
//            }
//            return -1;
//        }
//    }

    /* Search insert position*/
    // public static int searchInsert(int[] nums, int target) {
    //         int start = 0;
    //         int end = nums.length-1;

    //         Boolean found = false;
    //         if(target > nums[end]){
    //             return nums.length;
    //         }
    //         if(target < nums[start]){
    //             return start;
    //         }
    //         int mid =0;
    //         while(start < end){
    //             mid = start+end / 2;
    //             if(nums[mid] == target){
    //                 System.out.println("Fond");
    //                 return mid;
    //             }else if(nums[mid] < target){
    //                 start = mid;
    //             }else {
    //                 end = mid-1;
    //             }

    //             System.out.println("mm"+mid);
    //         }
    //         return mid;
    //     }

    /*
     * [4,5,6,7,0,1,2]
     * left =0; right =6
     * while(left<right){
     * mid = left + (right-left)/2;
     * if(mid == target){
     * return mid; 
     * }
     * if(target < mid){
     *  left = mid+1;
     * }else{
     *  right = mid+1;
     * }
     * }
     */
    // public static boolean search(int[] nums, int target) {
    //     // lower and upper bounds
    //     int low = 0;
    //     int high = nums.length-1;
    //     //loop through the array
    //     while(low<=high){
    //         //find mid
    //         int mid = low + (high-low)/2;
    //         if(nums[mid] == target){
    //             return true;
    //         }
    //         //check for sorted section
    //         if(nums[low] <= nums[mid]){
    //             // if it exist in sorted setion
    //             if(nums[low] <= target && target <= nums[mid]){
    //                 high = mid -1;
    //             }else {
    //                 low = mid +1;
    //             }
    //         }else {
    //             if(nums[mid] <= target && target <= nums[high]){
    //                 low = mid+1;
    //             }else {
    //                 high = mid-1;
    //             }
    //         }
        
    //     }
    //     return false;
    // }
    /*
     * Find the best avg grade of a student 
     * // Input :  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
     * // Output : 99 
     */



    // public static int bestAverage(String[][] input){
    //     HashMap<String, ArrayList<Integer>> hs = new HashMap<>();
    //     for( int i = 0; i<input.length;i++){
    //         String std = input[i][0];
    //         int score = Integer.parseInt(input[i][1]);
    //         if(hs.containsKey(std)){
    //             hs.get(std).add(score);
    //         }else{
    //             ArrayList<Integer> temp = new ArrayList<>();
    //             temp.add(score);
    //             hs.put(std, temp);
    //         }
    //     }
    //     int max = 0;
    //         ArrayList<Integer> avgScore = new ArrayList<>();
    //         for(Map.Entry<String, ArrayList<Integer>> temp : hs.entrySet()){
    //             int sum =0;
    //             for(int s : temp.getValue()){
    //                 sum+=s;
    //             }
    //             int avg = sum/temp.getValue().size();
    //             avgScore.add(avg);
    //         }

    //         for(int s : avgScore){
    //             if(s > max){
    //                 max = s; 
    //             }
    //         }
    //         return max;
    // }

    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

    // public static int josephus(int n, int k){
    //     ArrayList<Integer> st = new ArrayList<>();
    //     for( int i = 1;i<=n;i++){
    //         st.add(i);
    //     }
    //     int i = 0;
    //     while(st.size()!=1){
    //         st.remove((i+k-1) % st.size());
    //         i++;
    //     }
    //     return st.get(0);
    // }
    /*
     *     24. Return the highest substring length and index value. 
            1. EX: AAABBBBBBBBCCVV
            2. Output: B 8 index as well
     */

    // public static String higheString(String s){
    //     int l=0,r=1,max=0,len=0,start=0,end=0;
    //     char ch = s.charAt(l); 
    //     while(r<s.length()){
    //         if(s.charAt(r)!= s.charAt(r-1)){
    //             len = r-l;
    //             if(len> max){
    //                 max = len;
    //                 ch = s.charAt(r-1);
    //                 start = l;
    //                 end = r-1;
    //             }
    //             l=r;
    //         }
    //         r++;
    //     }

    //     len = r-l;
    //     if(len> max){
    //         max = len;
    //         ch = s.charAt(r-1);
    //         start = l;
    //         end = r-1;
    //     }

    //     return ""+ ch + "->" + max+ "->" + start +" ->" + end;
        
    // }

    /*
     * Array Rotation 
     * Left rotate
     * 
     */

    public static List<Integer> rotateLeft(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        for( int j = 0; j<k%arr.length;j++){
        int temp = arr[0];
        for( int i =1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1]= temp;
    }
        for(int i : arr){
            res.add(i);
        }
        return res;
    } 

    public static List<Integer> reverseRotateLeft(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr,0,arr.length-1);
        for(int i : arr){
        res.add(i);
        }

        return res;
    }
    public static void reverse(int[] a, int start, int end){
        int i = start;
        int j = end;
        while(i<=j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    /*
     * Array rotation 
     * Right rotate
     */
    public static List<Integer> rotateRight(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        for( int j = 0 ; j<k%arr.length;j++){
        int temp = arr[arr.length-1];
        for( int i = arr.length-1;i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
        for(int i : arr){
            res.add(i);
        }
        return res;
    }

    public static List<Integer> reverseRotateRight(int[] arr, int k){
        List<Integer> res = new ArrayList<>();
        reverseI(arr, 0, arr.length-1);
        reverseI(arr, 0, k-1);
        reverseI(arr, k, arr.length-1);

        for( int i : arr){
            res.add(i);
        }

        return res;
    }

    public static void reverseI(int[]a,int start, int end){
        while(start<=end){
            int temp = a[start];
            a[start]= a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    /*
     * Balanced Bracket
     * "{[()]}","[{})","[",")"
     */

    public static boolean banacedBracket(String s){
        Stack<Character> st = new Stack<>();
        for(int i =0; i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')){
                    char temp = st.pop();
                    if((temp == '{' && s.charAt(i) != '}') ||
                    (temp == '(' && s.charAt(i) != ')') ||
                    (temp == '[' && s.charAt(i) != ']') ){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
    }

    /*
     * LinkedLink reversal
     */

    // public static void linkedListReversal(Node head){
    //     Node curr = head;
    //     Node prev = null;
    //     while(curr!=null){
    //         Node temp = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr= temp;

    //     }

    //     return prev;
    // }

    /*
     * First repeating character
    Description: Identify the first character in a string that repeats.
    Constraints:
    Input string contains only lowercase English letters.
    Return the first repeated character in order of appearance, or '0' if there are no repeating characters.

     */
    public static char firstRepeatingCharacter(String s){
        HashSet<Character> hs = new HashSet<>();

        for( int i =0; i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                return s.charAt(i);
            }
            hs.add(s.charAt(i));
        }
        return '0';
    }
    /*
     *  Repeating Substring of Minimum Length
        Description: Find the smallest substring of a string that, when repeated, forms the entire string.
     */

    public static String subStringMinimumLength(String s){
        
        for( int i = 1; i<s.length()/2;i++){
            String subStr = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            // repreate check

            for( int j = 0; j < s.length()/i; j++){
                sb.append(subStr);
                if(sb.toString().equals(s)){
                    return subStr;
                }
            }
           
        }

        return s;
    }

    /*
     * Palindrome 
     * check if string is palindrome
     */

    public static boolean isPalindrome(String s){
        // StringBuilder sb = new StringBuilder();
        // for(int i = s.length()-1; i>=0;i--){
        //     sb.append(s.charAt(i));
        // }
        // return sb.toString().equals(s) ? true : false;
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /*
     * Fibonacci
     * print nth team;
     */
    public static int fab(int n){
        int first = 0;
        int sec = 1;
        int res = 0;
        for( int i=0; i<n-2;i++){
            res = first+sec;
            first = sec;
            sec = res;
        } 

        return res;
    }

    /*
     * Longest sumarray with  sum k
     */

    public static int longestSubArrayWithSumK(int[] arr, int k){
        int i = 0;
        int j = 0; 
        int max = 0;
        int sum= 0;
        while(j<arr.length){
            sum+=arr[j];
            if(sum<=k){
                max = Math.max(max, j-i+1);
            }else{
                i=j;
                sum= 0;
            }
            j++;
            // System.out.println(max);
        }
        
        return max;
    }
    

    /*
     * ++++++++++++++++++++++++++++++++++++++++++++++++++
     */

    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at pos	ition 5 is killed. So the person at position 3 survives.  
If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

    public static int josephusProblem(int n, int k){
        ArrayList<Integer> arr = new ArrayList<>();
        for( int i =0; i<n; i++){
            arr.add(i+1);
        }

        //

        // 12345
        // 1345
        // 134
        //
        int j = 0;
        while(arr.size()!=1){
            int temp = 
            arr.remove((j+k-1)%arr.size());
            j =  j+k-1;
        }

        return arr.get(0);
    }


    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function). 
Read in and ignore any leadin	g whitespace. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2). If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. Return the integer as the final result.
     */

    public static int myAtoi(String s){
        s = s.trim();
        // check for positioiivfe
        int i =0;
        if(s.length()==0){
            return 0;
        }
        boolean isPositive = true;
        // "-42"
        if(s.charAt(i) == '-'){
            isPositive = false;
            i++;
        }else if(s.charAt(i) == '+'){
            //"+42"
            i++;
        }
        //+42
        //9999999999999+4 > 2^31; -99999999999999 < -2^31 -1

        int res = 0;
        while(i<s.length()-1 && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if(res > (Integer.MAX_VALUE - digit)/ 10){
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res *10 + digit;
            i++;
        }
        return res;
    }

    // public static double midea(int[] n ,  int[]m ){
    //     //array of size ,m+n;
    //     //iter both and add the smaller index to m+n; 
    //     // will add left over to the new arr
    //     // sorted array with n + m elements
    //     // check lean of new arrya  if %2 == 0 
    //     // mid and mid-1
    //     // mid 
    //     int[] s = new int[n.length+m.length];
    //     int i = 0;
    //      int j = 0;
    //      int k = 0;
    //     while( i <n.length && j<m.length  ){
    //         if(n[i] < m[j]){
    //             s[k] = n[i];
    //             k++;
    //             i++;
    //         }else if (n[i] > m [j]){
    //             s[k] = m[j];
    //             k++;
    //             i++;
    //         }
    //         while(i<n.length) {
    //             s[k] = n[i];
    //             i++;
    //             k++;
    //         }
    //         while(j<m.length) {
    //             s[k] = n[j];
    //             j++;
    //             k++;
    //         }

    //         if(s.length%2 == 0){
    //             return ( (double)s[s.length/2] + (double)s[s.length/2-1])/2.0;
    //         }else{
    //             return (double) s[s.length/2];
    //         }
    //     }
    // }


    public static double midea(int[] n ,  int[]m ){
        //1234 and 567
        //take smaller array
        // binary serarch to that
        // smaller mid = l+r/2 barrray bmid = (n1+n2)/2 - mid;
        //bleft, bright, sleft and sright 
        // bleft = bmid > 0 ? m[mid-1] : -inf
        // bright = bmid < len ? m[mid] : +inf
        // sleft = mid > 0 ? m[mid-1] : -inf
        // sright = mid < len ? m[mid] : +inf

        // bleft <= sright && sleft <=bright
        // return if()
        return 0.0;
    }
    /*
     * Given an integer array of size n. Elements of the array is >= 0. Starting from arr[startInd], follow each element to the index it points to. 
     * Find a cycle and return its length. No cycle is found -> -1. 
lengthOfCycle([1, 0], 0); // 2 
lengthOfCycle([1, 2, 0], 0); // 3 
lengthOfCycle([1, 2, 3, 1], 0); // 3 
     */
    public static int arrayCycle(int[] arr, int si){
        int steps = 0;
        int curr = si;
        HashMap<Integer, Integer> hm  = new HashMap<>();
        while(curr<arr.length && curr >=0){
            if(hm.containsKey(arr[curr])){
                return steps - hm.get(curr);
            }
            hm.put(arr[curr], steps);
            steps++;
            curr = arr[curr];
        }
        return -1;
    }

    
    public static void main(String args[]){
        
        
    }
}
