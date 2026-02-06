class Solution {
    static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        static int maxTime = 0;

        // Initialize queue with rotten oranges
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == 2) {


                    q.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if (nRow >= 0 && nCol >= 0 &&
                    nRow < rLen && nCol < cLen &&
                    grid[nRow][nCol] == 1) {

                    grid[nRow][nCol] = 2;
                    fresh--;
                    q.offer(new Pair(nRow, nCol, time + 1));
                }
            }
        }

        return fresh == 0 ? maxTime : -1;
    }
}
