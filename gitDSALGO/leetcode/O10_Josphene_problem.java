package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.List;

public class O10_Josphene_problem {
    /*
     * In computer science and mathematics, the Josephus Problem (or Josephus permutation) is a theoretical problem. Following is the problem statement:  
There are n people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. Given the total number of person n and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive. 
For example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person at position 2 is killed, then the person at position 4 is killed, then the person at position 1 is killed. Finally, the person at position 5 is killed. So the person at position 3 survives.  
If n = 7 and k = 3, then the safe position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, and the person at position 4 survives. 
     */

    public static int lastLive(int n, int k){
        List<Integer> ls = new ArrayList<>();
        for( int i = 0; i<n;i++){
            ls.add(i+1);
        }

        int j = 0;
        while(ls.size()!=1){
            int temp = (k+j-1)% ls.size();
            ls.remove(temp);
            j = temp;
        }
        return ls.get(0);
    }z
}
