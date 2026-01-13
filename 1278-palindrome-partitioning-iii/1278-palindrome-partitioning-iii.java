class Solution {
    int n;
    String str ;
    Integer[][] dp;
    
    public int palindromePartition(String s, int k) {
        n = s.length();
        dp= new Integer[n][k+1];
        str = s;
        return solve(0,k );
    }
    public int solve(int idx , int k){
        if(idx == n && k == 0) return 0;
        if(idx == n || k == 0) return (int)1e9 ;
        if(dp[idx][k] != null) return dp[idx][k];

        int mini = (int) 1e9 ;
        for(int j = idx ; j < n ; j++){
            int change = checkPalindromeCount(idx , j);
            int cost = change + solve(j+1 , k-1);
            mini = Math.min(mini , cost);

        }
        return dp[idx][k] = mini;
    }
    
    public int checkPalindromeCount(int i , int j){
        int count = 0;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)){
                count++;
            }
            i++;
            j--;
        }
    return count;
    }
}