class Solution {
    public int differenceOfSums(int n, int m) {
        int sumyes=0, sumno=0;
        for(int i=0; i<=n; i++){
            if (i % m == 0){
                sumyes += i;
            }
            else{
                sumno += i;
            }
        }
        int res = sumno - sumyes;
        return res;
    }
}