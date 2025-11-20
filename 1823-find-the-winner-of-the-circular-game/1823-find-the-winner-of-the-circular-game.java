class Solution {
    public int findTheWinner(int n, int k) {
        if(n==1 && k==1) {
            return 1;
        }
        return helper(n,k)+1;
    }
    public int helper(int n, int k){
        if(n==1){
            return 0;
        }
        int next=helper(n-1, k);
        return (next+k)%n;
    }
}