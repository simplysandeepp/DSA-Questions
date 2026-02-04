class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0; i< n; i++){
            for(int j=0; j< dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(val, wt, W, n-1,dp);
    }

    int helper(int[] val, int[] wt, int W, int n, int[][] dp) {
        if (n < 0 || W == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n] <= W) {
            int include = val[n] + helper(val, wt, W - wt[n], n - 1, dp);
            int exclude = helper(val, wt, W, n - 1, dp);
            dp[n][W] =  Math.max(include, exclude);
            return dp[n][W];
            
        }
        else {
            dp[n][W] = helper(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }
}
