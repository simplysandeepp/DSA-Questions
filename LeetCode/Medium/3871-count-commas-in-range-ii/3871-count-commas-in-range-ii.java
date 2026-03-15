class Solution {
    public long countCommas(long n) {
        long t =0; // total
        long s=1000; //start 
        int c=1; //commas
        while(s <= n) {
            long e = Math.min(n, s * 1000 -1);
            long count = e - s + 1;
            t += count * c;
            s *= 1000;
            c++;
        }
        return t;
    }
}