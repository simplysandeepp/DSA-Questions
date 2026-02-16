import java.util.*;

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );
        
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // row, col, cost
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];
            int cost = current[2];
            
            if (row == m - 1 && col == n - 1) {
                return cost;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow < 0 || newCol < 0 ||
                    newRow >= m || newCol >= n) continue;
                
                int newCost = cost + grid[newRow][newCol];
                
                if (newCost < dist[newRow][newCol]) {
                    dist[newRow][newCol] = newCost;
                    pq.offer(new int[]{newRow, newCol, newCost});
                }
            }
        }
        
        return -1;
    }
}
