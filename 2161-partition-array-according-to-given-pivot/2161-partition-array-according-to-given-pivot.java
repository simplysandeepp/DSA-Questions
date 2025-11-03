class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int size = nums.length;
        int resultArray[] = new int[size];
        int index = 0;
        int pivotCount = 0;

        for(int num : nums) {
            if(num < pivot) {
                resultArray[index++] = num;
            } else if(num == pivot) {
                pivotCount++;
            }
        }
        while(pivotCount > 0) {
            resultArray[index++] = pivot;
            pivotCount--;
        }

        for(int num : nums) {
            if(num > pivot) {
                resultArray[index++] = num;
            }
        }

        return resultArray;
    }
}