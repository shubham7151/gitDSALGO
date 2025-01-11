package gitDSALGO.leetcode;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class O9_Find_Student_score_with_second_Best_Average {
    /*
     * Find student with second best average 
     */

    // Input :  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
    // Output : 99 

    public static String bestAverageGrade(String[][] l){
        HashMap<String, List<Integer>> hm = new HashMap<>();
        for( int i = 0; i< l.length;i++){
            String name = l[i][0];
            int score = Integer.parseInt(l[i][1]);
            if( hm.containsKey(name)){
                List<Integer> temp = hm.get(name);
                temp.add(score);
                hm.put(name, temp);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(score);
                hm.put(name, temp);
            }
        }

        int largestScore = Integer.MIN_VALUE;
        int seclargestScore = Integer.MIN_VALUE;
        String candidate = "";
        
        for(Map.Entry<String, List<Integer>> temp : hm.entrySet()){
            int sum = 0;
            for( Integer i : temp.getValue()){
                sum+=i;
            }
            int avg = sum / temp.getValue().size();
            if(avg> largestScore){
                seclargestScore = largestScore;
                largestScore = avg;
            }else if( avg > seclargestScore && avg != largestScore){
                seclargestScore = avg;
            }
        }
        for(Map.Entry<String, List<Integer>> temp : hm.entrySet()){
            int sum = 0;
            for( Integer i : temp.getValue()){
                sum+=i;
            }
            int avg = sum / temp.getValue().size();
            if(avg == seclargestScore){
                candidate = temp.getKey();
            }
        }

        return candidate + "->" + seclargestScore;
    }

    public static void main(String[] args) {
        String[][] st = new String[][]{{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"} };
        System.out.println(bestAverageGrade(st));

    }
}

