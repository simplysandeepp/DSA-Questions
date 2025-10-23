class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = (a | b) ^ c;
        int extraFlips = (a & b) & flips;
        return Integer.bitCount(flips) + Integer.bitCount(extraFlips);
    }
}