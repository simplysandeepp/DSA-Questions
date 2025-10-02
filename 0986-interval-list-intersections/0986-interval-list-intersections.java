class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final List<int[]> res = new ArrayList<>();     
        int p1 = 0;
        int p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            final var i1 = firstList[p1];
            final var i2 = secondList[p2];
            if (overlap(i1, i2)) {
                res.add(new int[]{Math.max(i1[0], i2[0]), Math.min(i1[1], i2[1])});
            }
            if (i1[1] < i2[1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return res.toArray(int[][]::new);
    }

    private static boolean overlap(final int[] a, final int[] b) {
        return b[1] >= a[0] && b[0] <= a[1];
    }
}