class Solution {
    Integer[][] dp;
    String s;
    public int countDigitOne(int n) {
        s = String.valueOf(n);
        int len = s.length();
        dp = new Integer[len][2];
        return solve(0, 1);
    }
    private int solve(int idx, int tight) {
        if (idx == s.length()) {
            return 0;
        }
        if (dp[idx][tight] != null) {
            return dp[idx][tight];
        }
        int ub = (tight == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;

        for (int digit = 0; digit <= ub; digit++) {
            int newTight = (tight == 1 && digit == ub) ? 1 : 0;
            if (digit == 1) {
                res += 1 + solve(idx + 1, newTight);
            } else {
                res += solve(idx + 1, newTight);
            }
        }

        return dp[idx][tight] = res;
    }
}
