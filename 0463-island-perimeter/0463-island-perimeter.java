class Solution {
    static int rowl;
    static int coll;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int islandPerimeter(int[][] grid) {
        rowl = grid.length;
        coll=grid[0].length;
        boolean vis[][] = new boolean[rowl][coll];
        for(int i=0;i<rowl;i++) {
            for(int j=0; j<coll;j++) {
                if(grid[i][j]==1 && !vis[i][j]) {
                    int peri = dfs(i,j,grid,vis);
                    return peri;
                }
            }
        }
        return 0;
    }
    public static int dfs(int r, int c, int[][] grid, boolean[][] vis) {
        if(r<0 || c<0 || r>=rowl || c>=coll || grid[r][c]==0) {
            return 1;
        }
        if(vis[r][c]==true){
            return 0;
        }
        vis[r][c] = true;
        int peri=0;
        for(int i=0; i<4; i++) {
            peri += dfs(r+dr[i], c+dc[i], grid, vis);
        }
        return peri;
    }
}