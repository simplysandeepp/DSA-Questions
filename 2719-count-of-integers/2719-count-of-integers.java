class Solution {
    int min;
    int max;
    static final int len=24;
    static final int maxsum=200;
    static final int MOD=(int) 1e9+7;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        StringBuilder sb=new StringBuilder(num1);
        int i=sb.length()-1;
        while(i>=0 && sb.charAt(i)=='0'){
            sb.setCharAt(i,'9');
            i--;
        }
        sb.setCharAt(i,(char)(sb.charAt(i)-1));
        String num=sb.toString();
        min=min_sum;
        max=max_sum;
        Integer[][][] dp1=new Integer[len][2][maxsum];
        Integer[][][] dp2=new Integer[len][2][maxsum];
        int ans=solve(num2,0,1,0,dp1)-solve(num,0,1,0,dp2);//idx,tight,sum
        if(ans<0){
            ans+=MOD;
        }
        return ans;
    }
    public  int solve(String s,int idx,int tight,int sum,Integer[][][] dp){
            if(idx==s.length()){
                if(sum>=min && sum<=max){
                    return 1;
                }else{
                    return 0;
                }
            }
            if(sum>max){
                return 0;
            }
            if(dp[idx][tight][sum]!=null){
                return dp[idx][tight][sum];
            }
            int lb=0;
            int ub=(tight==1)? s.charAt(idx)-'0': 9;

            int res=0;
            for(int digit=lb;digit<=ub;digit++){
                int newTight=(tight==1 && digit==ub)? 1 : 0;
                res=(res+solve(s,idx+1,newTight,sum+digit,dp))% MOD;
            }
            return dp[idx][tight][sum]=res;
    }
}