class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        return solve(arr, 1, n);
    }

    public int solve(int[] nums, int i, int j) {
        if (i > j) return 0;

        int maxi = Integer.MIN_VALUE;

        for (int idx = i; idx <= j; idx++) {
            int cost =
                nums[i - 1] * nums[idx] * nums[j + 1]
                + solve(nums, i, idx - 1)
                + solve(nums, idx + 1, j);

            maxi = Math.max(maxi, cost);
        }
        return maxi;
    }
}
