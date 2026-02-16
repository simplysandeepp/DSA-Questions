class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length
        boolean[][][] visited = new boolean[m][n][k+1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        
        int steps = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                int remaining = current[2];
                
                if (row == m - 1 && col == n - 1) {
                    return steps;
                }
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    
                    if (newRow < 0 || newCol < 0 || 
                        newRow >= m || newCol >= n) continue;
                    
                    int newRemaining = remaining;
                    
                    if (grid[newRow][newCol] == 1) {
                        if (remaining == 0) continue;
                        newRemaining = remaining - 1;
                    }
                    
                    if (!visited[newRow][newCol][newRemaining]) {
                        visited[newRow][newCol][newRemaining] = true;
                        queue.offer(new int[]{newRow, newCol, newRemaining});
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}
