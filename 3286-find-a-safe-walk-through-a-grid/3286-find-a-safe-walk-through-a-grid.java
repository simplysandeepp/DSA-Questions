class Solution {
    public boolean findSafeWalk(final List<List<Integer>> grid, final int health) {
        final int m = grid.size(), n = grid.get(0).size();
        final int[][] dirs = new int[][] { 
            { 0, 1 }, 
            { 1, 0 }, 
            { 0, -1 }, { -1, 0 } };
        final int[][] healths = new int[m][n];

        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        queue.offer(new int[] { 0, 0, health - grid.get(0).get(0) });

        while(!queue.isEmpty()) {
            final int[] curr = queue.poll();

            if(curr[2] == 0)
                continue;

            if(curr[0] == m - 1 && curr[1] == n - 1)
                return true;

            for(final int[] dir : dirs) {
                final int newX = curr[0] + dir[0], newY = curr[1] + dir[1];

                if(newX < 0 || newY < 0 || newX >= m || newY >= n)
                    continue;

                final int newHealth = curr[2] - grid.get(newX).get(newY);

                if(healths[newX][newY] >= newHealth)
                    continue;

                healths[newX][newY] = newHealth;

                queue.offer(new int[] { newX, newY, newHealth });
            }
        }

        return false;
    }
}