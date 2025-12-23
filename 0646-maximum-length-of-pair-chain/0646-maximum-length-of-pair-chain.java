public class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int maxL = 1;
        int prev = pairs[0][1];
        for(int i=1; i<pairs.length; i++) {
            if(prev < pairs[i][0]) {
                maxL++;
                prev = pairs[i][1];

            }
        }
        return maxL;
    }
}