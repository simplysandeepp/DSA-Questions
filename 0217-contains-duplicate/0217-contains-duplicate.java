class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int j = 1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[j]){
                return true;
            } else {
                j++;
            }
        } return false;
    }
}