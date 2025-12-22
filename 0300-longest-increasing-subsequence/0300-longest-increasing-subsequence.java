class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(0, -1, nums);
    }
    public int solve(int curr, int prev, int[] nums) {
        if(curr == nums.length) {
            return 0;
        }
        int notTake = solve(curr+1 , prev, nums);
        int take =0;
        if(prev == -1 || nums[curr] > nums[prev]) {
            take = 1 + solve(curr+1, curr, nums);
        }
        return Math.max(take, notTake);
    }
}