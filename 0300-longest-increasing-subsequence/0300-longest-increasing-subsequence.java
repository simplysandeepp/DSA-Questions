// RECURSION !!

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         return solve(0, -1, nums);
//     }
//     public int solve(int curr, int prev, int[] nums) {
//         if(curr == nums.length) {
//             return 0;
//         }
//         int notTake = solve(curr+1 , prev, nums);
//         int take =0;
//         if(prev == -1 || nums[curr] > nums[prev]) {
//             take = 1 + solve(curr+1, curr, nums);
//         }
//         return Math.max(take, notTake);
//     }
// }

// MEMOIZATION
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         Integer[][] dp = new Integer[n][n+1];
//         return solve(0, -1, nums, dp);
//     }
//     public int solve(int curr, int prev, int[] nums, Integer[][]dp) {
//         if(curr == nums.length) {
//             return 0;
//         }
//         if(dp[curr][prev+1] != null) {
//             return dp[curr][prev+1];
//         }
//         int notTake = solve(curr+1 , prev, nums, dp);
//         int take =0;
//         if(prev == -1 || nums[curr] > nums[prev]) {
//             take = 1 + solve(curr+1, curr, nums, dp);
//         }
//         dp[curr][prev+1] =  Math.max(take, notTake);
//         return dp[curr][prev+1];
//     }
// }



// TABULATION

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n + 1][n + 1];

//         for (int curr = n - 1; curr >= 0; curr--) {
//             for (int prev = curr - 1; prev >= -1; prev--) {
//                 int notTake = dp[curr + 1][prev + 1];
//                 int take = 0;
//                 if (prev == -1 || nums[curr] > nums[prev]) {
//                     take = 1 + dp[curr + 1][curr + 1];
//                 }
//                 dp[curr][prev + 1] = Math.max(take, notTake);
//             }
//         }
//         return dp[0][0];
//     }
// }


// SPACE OPTIMIZATION - 1 D ARRAY

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {
                int notTake = dp[curr + 1][prev + 1];
                int take = 0;
                if (prev == -1 || nums[curr] > nums[prev]) {
                    take = 1 + dp[curr + 1][curr + 1];
                }
                dp[curr][prev + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}
