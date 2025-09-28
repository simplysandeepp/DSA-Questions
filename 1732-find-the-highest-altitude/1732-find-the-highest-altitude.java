class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int first = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            first += gain[i];
            max = Math.max(max, first);
        }
        return max;
    }
}