class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxi = numBottles;
        while(numBottles >= numExchange){
            int res = numBottles / numExchange ;
            maxi += res;
            numBottles = res + (numBottles % numExchange);
        }
        return maxi;
    }
}