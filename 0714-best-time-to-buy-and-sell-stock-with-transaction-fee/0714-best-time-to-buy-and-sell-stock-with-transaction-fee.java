class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] i : dp) Arrays.fill(i, -1);
        return profit(prices, 0, 1, fee, dp);
    }

    private int profit(int[] prices, int ind, int buy, int fee, int[][] dp){
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            int take = -prices[ind] + profit(prices, ind + 1, 0, fee, dp);
            int noTake = profit(prices, ind + 1, 1, fee, dp);
            profit = Math.max(take, noTake);
        } else {
            int sell = prices[ind] - fee + profit(prices, ind + 1, 1, fee, dp);
            int noSell = profit(prices, ind + 1, 0, fee, dp);
            profit = Math.max(sell, noSell);
        }

        return dp[ind][buy] = profit;
    }
}