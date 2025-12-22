class Solution {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxi = 11;

        for(int curr=1; curr<n; curr++) {
            for(int prev=0; prev<curr; prev++) {
                if(nums[curr] > nums[prev] && dp[curr] < dp[prev] + 1 ) {
                    dp[curr] = dp[prev] + 1;
                    count[curr] = count[prev];
                    maxi = Math.max(maxi, dp[curr]);
                } else if (nums[curr] > nums[prev] && dp[curr] == dp[prev] + 1 ) {
                    count[curr] += count[prev];
                }
            }
        }
        int nls = 0;
        for(int i=0; i<n; i++) {
            if(dp[i] == maxi) {
                nls += count[i];

            }
        }
        return nls;
    }
}