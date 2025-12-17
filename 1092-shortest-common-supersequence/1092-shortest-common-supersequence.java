class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1.length(),str2.length(),str1,str2);
    }
    public String lcs (int n, int m, String s1, String s2) {
        StringBuilder ans = new StringBuilder();
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
        int i=n, j=m;
        while(i>0 && j>0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    ans.append(s1.charAt(i-1));
                    i--;
                }
                else {
                    ans.append(s2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i > 0) {
            ans.append(s1.charAt(i-1));
            i--;
        }
        while(j > 0) {
            ans.append(s2.charAt(j-1));
            j--;
        }
        return ans.reverse().toString();

    }
}