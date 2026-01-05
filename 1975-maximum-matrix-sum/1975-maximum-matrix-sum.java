class Solution {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minV = Integer.MAX_VALUE;
        int neg = 0;

        for (int[] arr : matrix) {
            for (int i : arr) {
                sum += Math.abs(i);
                if (i < 0) {
                    neg++;
                }
                minV = Math.min(minV, Math.abs(i));
            }
        }

        if (neg % 2 != 0) {
            sum -= 2 * minV;
        }

        return sum;
    }
}