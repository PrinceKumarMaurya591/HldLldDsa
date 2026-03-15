package com.conceptcoding.dsa.array.slidingwindow;


//Set two pointers:
//l = 0 (buy day)
//r = 1 (sell day)
//maxP = 0 to track maximum profit
//While r is within the array:
//If prices[r] > prices[l], compute the profit and update maxP.
//Otherwise, move l to r (we found a cheaper buy price).
//Move r to the next day.
//Return maxP at the end.
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] arr = {10,1,5,6,7,1};
        System.out.println( maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }

}
