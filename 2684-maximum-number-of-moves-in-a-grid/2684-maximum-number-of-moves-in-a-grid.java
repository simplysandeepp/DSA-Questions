class Solution {
    int res = 0;
    int rows, cols;
    
    public int maxMoves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, grid);
        }
        return res;
    }
    
    private void dfs(int i, int j, int[][] grid) {
        res = Math.max(res, j);
        if (res == cols - 1) return;

        for (int d = -1; d <= 1; d++) {
            int ni = i + d;
            if (ni >= 0 && ni < rows && grid[ni][j + 1] > grid[i][j]) {
                dfs(ni, j + 1, grid);
            }
        }
        grid[i][j] = 0;  // Mark as visited
    }
}