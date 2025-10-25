class Solution {
    public int minCostClimbingStairs(int[] c) {
        int n = c.length;
        int pre =c[1];
        int pre2=c[0];

        for(int i=2; i<n;i++ ){
            int curr = c[i] + Math.min(pre,pre2);
            pre2=pre;
            pre=curr;
        }
        return Math.min(pre,pre2);
    }
}