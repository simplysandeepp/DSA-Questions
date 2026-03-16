class NumArray {
    private long[] seg;
    private long[] arr;
    private int n;
    public NumArray(int[] nums) {
        n = nums.length;
        arr = new long[n];
        seg = new long[4 * n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }
        build(0, 0, n - 1);
    }
    public void build(int idx, int l, int r) {
        if (l == r) {
            seg[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * idx + 1, l, mid);
        build(2 * idx + 2, mid + 1, r);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }
    public void update(int idx, int l, int r, int pos, long val) {
        if (l == r) {
            seg[idx] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (pos <= mid)
            update(2 * idx + 1, l, mid, pos, val);
        else
            update(2 * idx + 2, mid + 1, r, pos, val);
        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }
    public long query(int idx, int l, int r, int qs, int qe) {
        if (r < qs || l > qe) return 0;
        if (qs <= l && r <= qe) return seg[idx];
        int mid = l + (r - l) / 2;
        long left = query(2 * idx + 1, l, mid, qs, qe);
        long right = query(2 * idx + 2, mid + 1, r, qs, qe);
        return left + right;
    }
    public void update(int index, int val) {
        update(0, 0, n - 1, index, val);
    }
    public int sumRange(int left, int right) {
        return (int) query(0, 0, n - 1, left, right);
    }
}