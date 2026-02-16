class Solution {
    public boolean findSafeWalk(final List<List<Integer>> grid, final int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dirs = new int[][] {{ 0, 1 },{ 1, 0 },{ 0, -1 },{ -1, 0 }};
        int[][] healthGrid = new int[m][n];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[] { 0, 0, health - grid.get(0).get(0) });
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[2] == 0)
                continue;
            if(curr[0] == m - 1 && curr[1] == n - 1)
                return true;
            for(int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n)
                    continue;
                int newH = curr[2] - grid.get(x).get(y);
                if(healthGrid[x][y] >= newH)
                    continue;
                healthGrid[x][y] = newH;
                queue.offer(new int[] { x, y, newH});
            }
        }
        return false;
        
}