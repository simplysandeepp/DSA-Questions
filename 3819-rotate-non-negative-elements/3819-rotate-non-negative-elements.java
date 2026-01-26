class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length; 
        int m = 0;
        int[] arr = new int[n];
        for (int i : nums) {
            if (i >= 0) {
                arr[m++] = i;

            }
        }
        if (m == 0) 
            return nums;
        k %= m;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] >= 0)  {
                nums[i] = arr[(j++ + k) % m];
            }
        }
        return nums;
    }
}