class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, grid, dp);
    }

    private int solve(int r, int c, int[][] grid, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (r >= m || c >= n) 
            return 0;

        if (grid[r][c] == 1) 
            return 0;

        if (r == m - 1 && c == n - 1) 
            return 1;

        if (dp[r][c] != -1)
            return dp[r][c];

        int right = solve(r, c + 1, grid, dp);
        int down  = solve(r + 1, c, grid, dp);

        return dp[r][c] = right + down;
    }
}
