class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];   
            }
            if (a[1] != b[1]) {
                return b[1] - a[1];   
            }
            return 0;
        });
        int n= envelopes.length;
        int[] dp = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int height = envelopes[i][1];

            int index = Arrays.binarySearch(dp, 0, len, height);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = height;

            if (index == len) {
                len++;
            }
        }

        return len;
    }
}
