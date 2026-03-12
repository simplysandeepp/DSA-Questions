class NumArray {
    private int[] arr;
    public NumArray(int[] nums) {
        int n = nums.length;
        arr = new int[n + 1];
        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + nums[i];
        }    
    }
    
    public int sumRange(int left, int right) {
        return arr[right+1] - arr[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */