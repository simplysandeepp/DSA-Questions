class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] temp = new int[2 * nums.length];
        for(int i=0; i<nums.length; i++){
            temp[i] = nums[i];
            temp[i+ nums.length] = nums[i];
        }
        return temp;
    }
}