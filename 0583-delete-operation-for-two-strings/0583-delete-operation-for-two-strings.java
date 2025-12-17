class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int l = lcs(n, m, word1, word2);
        // int ans =  [m+n] - 2*l;
        return m+n - 2*l;
  
    }
    int lcs (int n, int m, String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int [][] dp = new int [n+1][m+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}