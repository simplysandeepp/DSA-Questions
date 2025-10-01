class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0;
        for(int i=0;i<gas.length;i++){
            total+=(gas[i]-cost[i]);
        }
        if(total<0){ 
            return -1;
        }
        int idx=0;
        int currFuel=0;
        for(int i=0;i<gas.length;i++){
            currFuel+=(gas[i]-cost[i]);
            if(currFuel<0){
                currFuel=0;
                idx=i+1;
            }
        }

        return idx;
    }
}