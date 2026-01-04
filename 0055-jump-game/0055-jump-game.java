class Solution {
    public boolean canJump(int[] nums) {
        int maxi = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (maxi < i) {
                return false;
            }
            maxi = Math.max(maxi, i + nums[i]);
            if (maxi >= n - 1) {
                return true;
            }
        }
        return true;
    }
}
