package gitDSALGO.Concepts;

import java.util.Arrays;

public class Recursion {
    
    public static void func(int n){
        if( n==0){
            return;
        }
        System.out.println(n);
        func(n-1);
        System.out.println(n);
    }

    public static int fact( int n){
        if(n==0)
        return 1;
        return n*fact(n-1);
    }

    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }

    /*
     * sum of digits
     * 123%10 
     * 
     */

    public static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }

    /*
     *  product of all digits 
     */

    public static int productOfdigits(int n){
        if(n%10==n){
            return n;
        }
        return n%10 * productOfdigits(n/10);
    }

    /*
     * reverse a number
     */

     public static int reverseNumber(int n, int digits){
        if(n%10 == n){
            return n;
        }
        
        return (n%10 )*(int) (Math.pow(10, digits-1)) + reverseNumber(n/10 , digits-1);
     }

    /*
     * check if palindrome
     */

    public static boolean palindrome(int n){
        int digits = (int)(Math.log10(n))+1;
        System.out.println(reverseNumber(n, digits));
        return n==reverseNumber(n, digits);
    }

    /*
     * count number of zeros
     */
    public static int countZeros(int n){
        return cZero(n, 0);
    }
    
    public static int cZero(int n, int c){
        if(n%10==n){
            return c;
        }
        if(n%10==0){
            return cZero(n/10, c+1);
        }
        return cZero(n/10, c);
    }

    /*
     * find if array is sorted or not recursion
     */
    public static boolean sorted(int[] arr){
        if(arr.length==0){
            return true;
        }
        return sortedHelper(arr, 1);
    }

    public static boolean sortedHelper(int[] arr, int index){
        if(index==arr.length){
            return true;
        }
        if(arr[index] < arr[index-1]){
            return false;
        }
        return sortedHelper(arr, index+1);
    }

    /*
     *  linear search with recursion
     */

    public static int linearSearchRecussion(int[] arr, int i){
        if(arr.length==0){
            return -1;
        }
        return linearSearchHelper(arr,i, 0);
    }
    public static int linearSearchHelper(int[] arr, int i, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == i){
            return index;
        }
        return linearSearchHelper(arr, i, index+1);
    }

    /*
     *  rotated binary search
     * 
     */

    public static int binarySearch(int[] arr, int i){
        return binarySearchHealper(arr, i, 0, arr.length-1);

    }
    public static int binarySearchHealper(int[] arr, int i, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid] == i){
            return mid;
        }
        if(arr[mid] >= arr[start]){
            // sorted 
            if(arr[mid] > i && arr[start] <= i){
               return binarySearchHealper(arr, i, start, mid-1);
            }else{
               return binarySearchHealper(arr, i, mid+1, end);
            }
        } else{
            if(arr[mid] < i && arr[end] >= i){
               return binarySearchHealper(arr, i, mid+1, end);
            }else{
               return binarySearchHealper(arr, i, start, mid-1);
            }
        }       
    }

    /*
     * Pattern problem
     * ****
     * ***
     * **
     * *
     */

    public static void patternProblem(int i){
        patternProblemHelper(i,0);
    }

    public static void patternProblemHelper(int row, int col){
        if(row==0){
            return;
        }
        if(col<row){
            System.out.print("*");
            patternProblemHelper(row,col+1);
        }else{
            System.out.println();
            patternProblemHelper(row-1, 0);
        }
    }

    /*
     * Pattern 2 
     * *
     * **
     * ***
     * ****
     */

    public static void triangle(int row, int col){
        if(row==0){
            return;
        }
        if(col<row){
            triangle(row, col+1);
            System.out.print("*");
        }else{
            triangle(row-1, 0);
            System.out.println();
            
        }
    }

    /*
     * bubble sort
     * 
     */

    public static void bubbleSort(int[] arr){
         bubbleSortHelper(arr, arr.length-1, 0);
    }

    public static void bubbleSortHelper(int[] arr, int i, int j){

        if(i == 0){
            return ;
        }
        if(j<i){
            if(arr[j+1]  < arr[j]){
                //swap
                int temp = arr[j];
                arr[j] =  arr[ j+1];
                arr[j+1] = temp;
            }
            bubbleSortHelper(arr, i, j+1);
        }
        else{
            bubbleSortHelper(arr, i-1, 0);
        } 
         
    }

    /*
     * selection sort
     */

    public static void selectionSort(int[] arr){
        selectionSortHelper(arr,arr.length,0, 0);
    }
    public static void selectionSortHelper(int[] arr, int i, int j, int max){
        if(i==0){
            return;
        }
        if(j <i){
            if(arr[j] > arr[max]){
                selectionSortHelper(arr, i, j+1, j);
            }else{
                selectionSortHelper(arr, i, j+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] =  arr[ i-1];
            arr[i-1] = temp;
            selectionSortHelper(arr, i-1, 0, 0);
        }
        
    }


    /*
     * remove all a's from string with parameter
     */

    public static String removeA(String s){
        return removeAHelper(s,0,new StringBuilder()).toString();
    }

    public static StringBuilder removeAHelper(String s,int i, StringBuilder sb){
        if(i==s.length()){
            return sb;
        }
        if(s.charAt(i)!= 'a'){
            sb.append(s.charAt(i));
        }
        return removeAHelper(s, i+1, sb);
    }

    /*
     * remove all a's from string without parameter
     */

    public static String removeAWithout(String s){
        return removeAWithoutHelper(s,s.length()-1).toString();
    }

    public static StringBuilder removeAWithoutHelper(String s, int i){
        if(i==0){
            return new StringBuilder();
        }
        if(s.charAt(i)!= 'a'){
            return removeAWithoutHelper(s, i-1).append(s.charAt(i));
        }else{
            return removeAWithoutHelper(s, i-1);
        }
    }

   /*
    * without passing index 
    */

    public static String skipAwithoutIndex(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.charAt(0)!='a'){
            return s.charAt(0) + skipAwithoutIndex(s.substring(1));
        }else{
            return skipAwithoutIndex(s.substring(1));
        }
    }

    /*
     * skip a word rather 
     */

    public static String skipaWord(String s, String word){
        if(s.length()==0){
            return "";
        }
        if(!s.startsWith(word)){
            return s.charAt(0) + skipaWord(s.substring(1), word);
        }else{
            return skipaWord(s.substring(word.length()), word);
        }
    } 

    /*
     * skip a sub word when not equal to another word rather 
     */

     public static String skipaWord(String s, String sub, String word){
        if(s.length()==0){
            return "";
        }
        if(s.startsWith(sub) && !s.startsWith(word)){
            return skipaWord(s.substring(sub.length()), sub,word);
            
        }else{
            return s.charAt(0) + skipaWord(s.substring(1), sub,word);
        }
    } 
    public static void main(String[] args) {
        String s = "bacapplecdah";
        System.out.println(skipaWord(s, "app","apple"));
        
    }
}
