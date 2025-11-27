class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) return false;
        return isSafe(grid, 0, 0, 0);
    }

    public boolean isSafe(int[][] grid, int row, int col, int num) {
        int n = grid.length;

        if(num == n*n - 1) return true;

        int[][] moves = {
            {-2, 1}, {-2, -1},
            {-1, -2}, {1, -2},
            {-1, 2}, {1, 2},
            {2, -1}, {2, 1}
        };

        for(int[] m : moves){
            int i = row + m[0];
            int j = col + m[1];

            if(i>=0 && i<n && j>=0 && j<n && grid[i][j] == num+1){
                return isSafe(grid, i, j, num+1);
            }
        }
        return false;
    }
}
