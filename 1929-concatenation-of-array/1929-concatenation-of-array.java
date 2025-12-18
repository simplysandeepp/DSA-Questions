class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        int i = 0, j = 0;

        while (i < ans.length) {
            ans[i] = nums[j];
            i++;
            j++;

            if (j == n) {
                j = 0;
            }
        }
        return ans;
    }
}
