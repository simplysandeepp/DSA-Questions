class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lp = 0, rp = n-1, mw = 0;
        while(lp < rp) {
            int b = rp - lp;
            int l = Math.min(height[lp], height[rp]);
            int cw = l * b;
            mw = Math.max(mw, cw);
            int temp = height[lp] < height[rp] ? lp++ : rp--;
        }        
        return mw;
    }
}
// lp -> left pointer , rp -> right pointer
// mw -> max water, cw -> current water
// l -> length , b -> breadth
