class Solution {
    class Pair implements Comparable<Pair> {
        long mapped;
        int index;
        Pair(long mapped, int index) {
            this.mapped = mapped;
            this.index = index;
        }
        public int compareTo(Pair other) {
            if (this.mapped != other.mapped)
                return this.mapped < other.mapped ? -1 : 1;
            return this.index - other.index;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Pair(map(nums[i], mapping), i);
        Arrays.sort(arr);
        int[] res = new int[n];
        for (int i = 0; i < n; i++)
            res[i] = nums[arr[i].index];
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
