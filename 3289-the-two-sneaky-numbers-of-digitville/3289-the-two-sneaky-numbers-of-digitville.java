class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] hash = new int[101];
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        int ind = 0;
        for(int i = 0; i < 101; i++) {
            if(hash[i] == 2) {
                ans[ind] = i;
                ind++;
            }
        }
        return ans;
    }
}