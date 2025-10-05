class Solution {
    public int smallestEvenMultiple(int n) {
        int largest = Integer.MAX_VALUE;
        int i;
        for(i=1 ; i < largest; i++){
            if(i%2==0 && i%n==0) break;
        }
        return i;
    }
}