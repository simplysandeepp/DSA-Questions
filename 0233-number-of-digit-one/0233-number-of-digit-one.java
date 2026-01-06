class Solution {
    String s;
    long[][][] dp; 
    public int countDigitOne(int n) {
        s = String.valueOf(n);
        int len = s.length();
        dp = new long[len][2][2];
        for (int i = 0; i < len; i++) {
            for (int t = 0; t < 2; t++) {
                dp[i][t][0] = -1;
            }
        }

        return (int) solve(0, 1)[0];
    }

    private long[] solve(int idx, int tight) {
        if (idx == s.length()) {
            return new long[]{0, 1}; 
        }

        if (dp[idx][tight][0] != -1) {
            return dp[idx][tight];
        }

        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        long countOnes = 0;
        long countNums = 0;

        for (int digit = 0; digit <= ub; digit++) {
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            long[] next = solve(idx + 1, newTight);

            countNums += next[1];
            countOnes += next[0];

            if (digit == 1) {
                countOnes += next[1]; 
            }
        }

        dp[idx][tight][0] = countOnes;
        dp[idx][tight][1] = countNums;
        return dp[idx][tight];
    }
}
