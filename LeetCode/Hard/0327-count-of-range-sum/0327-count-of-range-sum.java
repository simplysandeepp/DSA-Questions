class Solution {
    static class SegmentTree {
        int n;
        int[] tree;
        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        public int query(int node, int leftR, int rightR, int querySt, int queryEnd) {
            if (leftR > queryEnd || rightR < querySt) return 0;
            if (querySt <= leftR && rightR <= queryEnd) return tree[node];
            
            int mid = leftR + (rightR - leftR) / 2;
            int left = query(2 * node + 1, leftR, mid, querySt, queryEnd);
            int right = query(2 * node + 2, mid + 1, rightR, querySt, queryEnd);
            return left + right;
        }

        public void update(int node, int leftR, int rightR, int idx) {
            if (leftR == rightR) {
                tree[node]++;
                return;
            }
            int mid = leftR + (rightR - leftR) / 2;
            if (idx <= mid) update(2 * node + 1, leftR, mid, idx);
            else update(2 * node + 2, mid + 1, rightR, idx);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long sum = 0;
        long[] pref = new long[n + 1];
        TreeSet<Long> set = new TreeSet<>();
        set.add(0L);
        
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            pref[i + 1] = sum;
            set.add(sum);
            set.add(sum - lower);
            set.add(sum - upper);
        }

        HashMap<Long, Integer> hm = new HashMap<>();
        int idx = 0;
        for (long val : set) hm.put(val, idx++);

        SegmentTree seg = new SegmentTree(idx);
        int result = 0;
        
        // Initial state: prefix sum 0 is already "seen"
        seg.update(0, 0, idx - 1, hm.get(0L));

        for (int i = 1; i <= n; i++) {
            int leftBound = hm.get(pref[i] - upper);
            int rightBound = hm.get(pref[i] - lower);
            
            // Query how many previous prefix sums fall in [sum - upper, sum - lower]
            result += seg.query(0, 0, idx - 1, leftBound, rightBound);
            seg.update(0, 0, idx - 1, hm.get(pref[i]));
        }
        return result;
    }
}