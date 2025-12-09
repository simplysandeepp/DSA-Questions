class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = solveRec(n - 1, amount, coins, dp);
        return ans >= 1e9 ? -1 : ans;
    }

    private int solveRec(int idx, int amount, int[] coins, int[][] dp) {
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return (int) 1e9; 
        }

        if (dp[idx][amount] != -1) 
            return dp[idx][amount];

        int notTake = solveRec(idx - 1, amount, coins, dp);

        int take = (int) 1e9;
        if (coins[idx] <= amount) {
            take = 1 + solveRec(idx, amount - coins[idx], coins, dp);
        }

        return dp[idx][amount] = Math.min(take, notTake);
    }
}
