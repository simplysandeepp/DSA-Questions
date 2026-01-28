class Solution {
    int m, n;

    public int calculateMinimumHP(int[][] power) {
        m = power.length;
        n = power[0].length;
        return solve(0, 0, power);
    }

    int solve(int i, int j, int[][] power) {
        if (i >= m || j >= n) 
        return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) {
            return power[i][j] >= 0 ? 1 : 1 - power[i][j];
        }

        int down = solve(i + 1, j, power);
        int right = solve(i, j + 1, power);

        int need = Math.min(down, right) - power[i][j];
        return need <= 0 ? 1 : need;
    }
}