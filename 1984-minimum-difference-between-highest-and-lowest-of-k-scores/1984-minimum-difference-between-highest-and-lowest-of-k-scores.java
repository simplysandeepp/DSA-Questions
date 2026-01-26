class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        for (int i=0; i<=n-k; i++) {
            int diff = nums[i+k-1] - nums[i]; 
            mini = Math.min(mini, diff);
        }
        return mini;
    }
}