class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dfs(grid, i, j, m, n, 2);
                }
            }
        }

        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) return -1; 
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes - 2; 
    }

    private void dfs(int[][] grid, int i, int j, int m, int n, int min) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < min)) 
            return;

        grid[i][j] = min; 

        dfs(grid, i - 1, j, m, n, min + 1);
        dfs(grid, i + 1, j, m, n, min + 1);
        dfs(grid, i, j - 1, m, n, min + 1);
        dfs(grid, i, j + 1, m, n, min + 1);
    }
}