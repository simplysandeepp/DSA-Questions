class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Arrays.sort(nums);
        int[] arr = new int[k];
        int[] values = new int[nums.length];
        int[] counts = new int[nums.length];
        int count = 1;
        int idx = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i < nums.length && nums[i] == nums[i - 1]) {
                count++;
            } else {
                values[idx] = nums[i - 1];
                counts[idx] = count;
                idx++;
                count = 1;
            }
        }
        for (int i = 0; i < k; i++) {
            int max = 0;
            for (int j = 1; j < idx; j++) {
                if (counts[j] > counts[max]) {
                    max = j;
                }
            }
            arr[i] = values[max];
            counts[max] = -1;
        }

        return arr;
    }
}
