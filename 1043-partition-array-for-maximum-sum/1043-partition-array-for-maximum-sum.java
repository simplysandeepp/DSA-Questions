class Solution {
    int n;
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, k, arr);
    }
    public int solve(int idx, int k, int[] arr) {
        if (idx == n) return 0;

        if (dp[idx] != -1) return dp[idx];

        int len = 0;
        int maxI = Integer.MIN_VALUE;
        int maxAns = 0;

        for (int i = idx; i < Math.min(n, idx + k); i++) {
            len++;
            maxI = Math.max(maxI, arr[i]);
            int cost = maxI * len + solve(i + 1, k, arr);
            maxAns = Math.max(maxAns, cost);
        }
        return dp[idx] = maxAns;
    }
}
