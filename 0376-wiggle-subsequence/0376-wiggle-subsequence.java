class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n= nums.length;
        if(n<2) {
            return n;
        }
        int pDiff = nums[1] - nums[0];
        int count = 1;
        if(pDiff != 0) {
            count = 2;
        }
        for(int i=2; i<n; i++) {
            int diff = nums[i] - nums[i-1];
            if((diff > 0 && pDiff <= 0) || (diff < 0 && pDiff >= 0)) {
                count++;
                pDiff = diff;
            }
        }
        return count;
    }
}