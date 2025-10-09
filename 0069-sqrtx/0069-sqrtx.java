class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x; // Base cases

        int i = 1, j = x;
        int mid = i + (j - i) / 2;

        while (i <= j) {
            if (mid == x / mid) return mid;
            else if (mid > x / mid)
                j = mid - 1;
            else
                i = mid + 1;

            mid = i + (j - i) / 2;
        }
        return j; // j will be floor(sqrt(x))
    }
}