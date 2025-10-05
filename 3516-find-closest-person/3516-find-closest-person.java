class Solution {
    public int findClosest(int x, int y, int z) {
        int ansa = z-x;
        int ansb = z-y;
        int a = Math.abs(ansa);
        int b = Math.abs(ansb);
        if(a < b){
            return 1;
        } else if (a > b) {
            return 2;
        } else {
            return 0;
        }
    }
}