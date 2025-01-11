package gitDSALGO.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1823_Find_the_Winner_of_the_Circular_Game {
    /*
     * Find the Winner of the Circular Game
     * josephus problem
     */

    public static int josephusproblem(int n,int k){
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
    }
}
