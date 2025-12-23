class Solution {
    public int maxHeight(int[][] cuboids) {
        for(int [] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        Arrays.sort(cuboids,(a,b) -> {
            return b[0]*b[1]*b[2]-a[0]*a[1]*a[2];
        });
        
        int n = cuboids.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            dp[i] = cuboids[i][2];
        }
        int maxi = dp[0];

        for(int curr=1; curr<n; curr++) {
            for(int prev=1; prev<curr; prev++) {
                if(cuboids[curr][0] <= cuboids[prev][0]
                && cuboids[curr][1] <= cuboids[prev][1]
                && cuboids[curr][2] <= cuboids[prev][2]
                )
                {
                    if(dp[curr] < dp[prev] + cuboids[curr][2]) {
                        dp[curr] = dp[prev] + cuboids[curr][2];
                    }
                }
            }
            maxi = Math.max(maxi, dp[curr]);
        }
        return maxi;
    }
}