class Solution {
    public int[] shuffle(int[] nums, int n) {
        int j=0;
        int arr[] = new int[2*n];
        for(int i=0; i<n; i++){
            arr[j++] = nums[i];
            arr[j++] = nums[i+n];
        }
        return arr;
    }
}