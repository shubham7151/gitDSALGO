package gitDSALGO.leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
// import javafx.util.Pair;

public class L621_Task_Scheduler {
        
    /*
     * Task Scheduler
     */

     public int leastInterval(char[] tasks, int n) {
        // save frequencey in priority queue / max heap with max firequency;
        // in a queue which records cooldown period have a pair of task count and cooldown
        // while q and pq is not empty
        // increment time
        // check if pq is not empty get task with most frequency
        // if its not 0 means taks is not finished add it to q with count and time + n
        // check if top of q is valid means its ready to process by check if q is not empty
        // and its top value == time
        // push it to pq and remove from q

        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c : tasks){
            if(freq.containsKey(c)){
                freq.put(c, freq.get(c)+1);
            }else{
                freq.put(c, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freq.values());

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!q.isEmpty() || pq.isEmpty()){
            time++;

            if(!pq.isEmpty()){
                int count= pq.poll()-1;

                if(count!=0){
                    q.add(new int[]{count,time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}


