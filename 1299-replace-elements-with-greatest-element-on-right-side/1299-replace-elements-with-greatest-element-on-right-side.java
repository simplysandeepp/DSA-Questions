class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int max = -1;
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, arr[j]);
            }
            arr[i] = max;
        }

        return arr;
    }
}
