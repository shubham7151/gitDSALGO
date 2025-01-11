package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class O5_Find_the_best_avg_grade_of_a_student {

    /*
     * Find the best avg grade of a student 
     */

    // Input :  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
    // Output : 99 

    public static double bestAverageGrade(String[][] l){
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();

        for(int i = 0; i< l.length;i++){
            if( hm.containsKey(l[i][0])){
                hm.get(l[i][0]).add(Integer.parseInt(l[i][1]));
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(Integer.parseInt(l[i][1]));
                hm.put(l[i][0], temp);
            }
            
        }
        double max = 0;
        for(Map.Entry<String, ArrayList<Integer>> temp : hm.entrySet()){
            // temp.getValue();
            int sum = 0;
            for(Integer i : temp.getValue()){
                sum+=i;
            }
            double avg = (double) sum/temp.getValue().size();
            max = Math.max(avg, max);
        }
        return max;
    }

    public static void main(String[] args) {
        String[][] st = new String[][]{{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"} };
        System.out.println(bestAverageGrade(st));

    }
}