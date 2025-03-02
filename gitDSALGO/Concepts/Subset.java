package gitDSALGO.Concepts;

import java.util.*;

public class Subset {
    
    /*
     * given a string find print subset of string
     */

    public static void allSubset(String s){
        allSubsetHelper("", s);
    }

    public static void allSubsetHelper(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);

        allSubsetHelper(processed+ch, unprocessed.substring(1));
        allSubsetHelper(processed, unprocessed.substring(1));
    }

    /*
     * given list return all subet as list
     * 
     */

    public static ArrayList<String> getAllSubset(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> t = new ArrayList<>();
            t.add(processed);
            return t;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = getAllSubset(processed+ch, unprocessed.substring(1));
        ArrayList<String> right = getAllSubset(processed, unprocessed.substring(1));
        
        left.addAll(right);
        System.out.println(left);
        return left;
    }

    /*
     * given an array of number find all subset
     */

    public static List<List<Integer>> allSubsetNumberRecursive(int[] arr){
        return allSubsetNumberRecursiveHelper(arr, 0, new ArrayList<>(), new ArrayList<>());
    }
    public static List<List<Integer>> allSubsetNumberRecursiveHelper(int[] arr, int i, List<List<Integer>> res, List<Integer> tempList){
        res.add(new ArrayList<>(tempList));
        for( ; i<arr.length;i++){
            
            tempList.add(arr[i]);
            allSubsetNumberRecursiveHelper(arr, i+1, res, tempList);
            tempList.remove(tempList.size()-1);

        }
        return res;
    }
    

    /*
     * given an array of number find all subset
     * iterative appraoch
     */

    public static List<List<Integer>> allSubsetNumber(int[] arr){
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for( int num : arr){
            int size = list.size();
            for(int i = 0; i<size;i++){
                List<Integer> innerList = new ArrayList<>(list.get(i));
                 innerList.add(num);
                 list.add(innerList);
            }
        }
        return list;
    }


    /*
     * given an array of number find all subset
     * iterative appraoch
     * 
     * with dupliocate
     */

     public static List<List<Integer>> allSubsetNumberDuplicate(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for( int j = 0; j<arr.length;j++){
            start = 0;
            if(j > 0 && arr[j] ==  arr[j-1]){
                start = end+1;
            }
            end = list.size()-1;
            int size = list.size();
            for(int i = start; i<size;i++){
                List<Integer> innerList = new ArrayList<>(list.get(i));
                 innerList.add(arr[j]);
                 list.add(innerList);
            }
        }
        return list;
    }

    
    public static void main(String[] args) {
       List<List<Integer>> st =  allSubsetNumberRecursive(new int[] {1,2,3});
       for( List<Integer>s : st){
        System.out.println(s);
       }
    }
}
