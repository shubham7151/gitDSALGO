package gitDSALGO.leetcode;

public class L1283_Find_the_Smallest_Divisor_Given_a_Threshold {
    
        public int smallestDivisor(int[] nums, int threshold) {
            
            int minD = Integer.MAX_VALUE;
            int maxD = Integer.MIN_VALUE;
    
            for( int i = 0; i<nums.length; i++){
                // minD = Integer.min(minD, nums[i]);
                maxD = Integer.max(maxD, nums[i]);
            }
    
        //    for( int i = 1; i <= maxD ;i++){
        //         int sum = 0;
        //         for( int j = 0; j<nums.length;j++){
        //             sum+= Math.ceil((double) nums[j] / (double) i);
        //         }
        //         if(sum<=threshold){
        //             return i;
        //         }
        //    }
    
            int ans = 0;
            int l = 0;
            int r = maxD;
            while(l<=r){
                int sum = 0;
                int mid = (l+r)/2;
                for( int j = 0; j<nums.length;j++){
                    sum+= Math.ceil((double) nums[j] / (double) mid);
                }
                if(sum<=threshold){
                    ans = mid;
                    r= mid-1;
                }else{
                    l = mid+1;
                }
    
    
            }
    
           return ans;
        }
    
}
