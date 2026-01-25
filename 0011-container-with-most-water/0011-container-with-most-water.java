class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int lp = 0, rp = n-1, maxi = 0;

// lp -> left pointer , rp -> right pointer
// maxi -> max water, cw -> current water
// l -> length , b -> breadth

        while(lp < rp) {
            int b = rp - lp;
            int l = Math.min(height[lp], height[rp]);
            int cw = l * b;
            maxi = Math.max(maxi, cw);
            int temp = height[lp] < height[rp] ? lp++ : rp--;
        }        
        return maxi;
    }
}
