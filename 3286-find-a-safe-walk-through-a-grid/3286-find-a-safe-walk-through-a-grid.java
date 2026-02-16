class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int[][] bh = new int[m][n];
        for (int[] row : bh) {
            Arrays.fill(row, -1);
        }

        int initial = health - grid.get(0).get(0);
        pq.offer(new int[]{0, 0, initial});
        bh[0][0] = initial;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int h = curr[2];

            if (x == m - 1 && y == n - 1 && h > 0) {
                return true;
            }

            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int nh = h - grid.get(nx).get(ny);
                if (nh > 0 && nh > bh[nx][ny]) {
                    bh[nx][ny] = nh;
                    pq.offer(new int[]{nx, ny, nh});
                }
            }
        }

        return false;
    }
}
