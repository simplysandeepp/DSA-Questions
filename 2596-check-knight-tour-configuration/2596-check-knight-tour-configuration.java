class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0] != 0) 
            return false;
        return isSafe(grid,0,0,0); // row col num
    }

    public boolean isSafe(int [][] grid, int row, int col, int num) {
        int n = grid.length;

        if(num == n*n-1){
            return true;
        }
        int i, j;

        i = row-2; j = col+1;
        if(i>=0 && j<n && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row-2; j = col-1;
        if(i>=0 && j>=0 && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row-1; j = col-2;
        if(i>=0 && j>=0 && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row+1; j = col-2;
        if(i<n && j>=0 && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row-1; j = col+2;
        if(i>=0 && j<n && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row+1; j = col+2;
        if(i<n && j<n && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row+2; j = col-1;
        if(i<n && j>=0 && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        i = row+2; j = col+1;
        if(i<n && j<n && grid[i][j]==num+1)
            return isSafe(grid, i, j , num+1);

        return false;
    }
}
