class Solution {
    Integer dp[][][];
  
    public int findIntegers(int n) {
        String s=Integer.toBinaryString(n);
        dp=new Integer[s.length()][2][2];
        return solve(s,0,1,0);
    }
    public int solve(String s ,int idx,int tight,int prev)
    {
        if(idx==s.length())
        return 1;
        if(dp[idx][tight][prev]!=null) return dp[idx][tight][prev];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':1;
        int res=0;
        for(int dig=lb;dig<=ub;dig++)
        {
            if(prev==1&&dig==1)
            continue;
            int newt=(tight==1&&dig==ub)?1:0;
            res+=solve(s,idx+1,newt,dig);
        }
        return dp[idx][tight][prev]=res;

    }
}