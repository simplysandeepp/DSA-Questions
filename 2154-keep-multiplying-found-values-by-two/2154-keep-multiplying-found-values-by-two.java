class Solution {
    public int findFinalValue(int[] nums, int key) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++ ){
            if(nums[i] == key) key*=2;
        }
        return key;
    }
}