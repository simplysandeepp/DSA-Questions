import java.util.*;

class Solution {
    public int minCost(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int max = 0;
        for (int[] r : grid)
            for (int v : r) max = Math.max(max, v);

        int[][] dp = new int[n][m];
        int[] bestAtVal = new int[max + 1];
        int[] prefix = new int[max + 1];

        Arrays.fill(bestAtVal, Integer.MAX_VALUE);
        bestAtVal[grid[n - 1][m - 1]] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) continue;
                int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(down, right);
                bestAtVal[grid[i][j]] = Math.min(bestAtVal[grid[i][j]], dp[i][j]);
            }
        }
        for (int step = 0; step < k; step++) {
            prefix[0] = bestAtVal[0];
            for (int v = 1; v <= max; v++)
                prefix[v] = Math.min(prefix[v - 1], bestAtVal[v]);
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (i == n - 1 && j == m - 1) continue;
                    int down = (i + 1 < n) ? dp[i + 1][j] + grid[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j + 1 < m) ? dp[i][j + 1] + grid[i][j + 1] : Integer.MAX_VALUE;
                    dp[i][j] = Math.min(Math.min(down, right), prefix[grid[i][j]]);
                    bestAtVal[grid[i][j]] = Math.min(bestAtVal[grid[i][j]], dp[i][j]);
                }
            }
        }

        return dp[0][0];
    }
}
