class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {

        int[] result = new int[friends.length];
        int j=0,k=0;
        for(int i=0;i<order.length;i++){
            for(j=0;j<friends.length;j++){
                if(order[i]==friends[j]){
                result[k]=order[i];
                k++;}
                if(order[i]<friends[j])
                break;
            }
        }       
            return result;
    }
}