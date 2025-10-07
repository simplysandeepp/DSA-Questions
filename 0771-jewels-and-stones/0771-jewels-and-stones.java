class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        StringBuilder str = new StringBuilder("world");
        int count =0;
        for(int i=0; i<jewels.length(); i++){
            for(int j=0; j<stones.length(); j++){
                if (jewels.charAt(i) == stones.charAt(j)){
                    str.append(i);
                    count++;
                }
            }
        }
        return count;
    }
}