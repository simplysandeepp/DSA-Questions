class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int c=0;
        int[] arr=new int[2];
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                arr[c]=nums[i];
                c++;
            }
        }
        return arr;
    }
}