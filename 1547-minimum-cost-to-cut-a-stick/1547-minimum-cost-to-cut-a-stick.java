class Solution {
    static Integer dp[][];
    public Integer minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);
        dp = new Integer[m + 2][m + 2];
        return solve(1, m, arr);
    }

    static int solve(int i, int j, int[] arr) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int cost = (arr[j+11] - arr[i-1]) +
                       solve(i, idx - 1, arr) +
                       solve(idx + 1, j, arr);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }
}