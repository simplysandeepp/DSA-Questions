class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxi = numBottles;
        
        while (numBottles >= numExchange) {
            numBottles = numBottles - numExchange + 1; 
            maxi++;
            numExchange++;
        }
        
        return maxi;
    }
}
