package gitDSALGO.leetcode;

public class L121 {

    /*
     * Best Time to Buy and Sell Stock
     */
    
    /*
     * intution : when local sum is less then 0 then no profit move left pointer 
     */

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int profit = 0;
        int localProfit = 0;
        while(right<prices.length){
            localProfit = prices[right] -  prices[left];
            if(localProfit < 0){
                left = right;
            }
            profit = Math.max(profit, localProfit);
            right++;
        }

        return profit;
    }
    public static void main(String[] args) {
        
    }
}
