class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        int n = nums.length;
        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = map(nums[i], mapping);
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = nums[(int) arr[i][1]];

        return res;
    }

    long map(int num, int[] m) {
        if (num == 0) return m[0];
        long val = 0, p = 1;
        while (num > 0) {
            val += m[num % 10] * p;
            p *= 10;
            num /= 10;
        }
        return val;
    }
}
